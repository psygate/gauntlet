/*
 *     Copyright (C) 2016 psygate (https://github.com/psygate)
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 */

package com.psygate.minecraft.spigot.gauntlet.patches;

//import com.psygate.minecraft.spigot.gauntlet.patches.v1_8_R3.*;

import com.psygate.minecraft.spigot.gauntlet.patches.v1_8_R3.PlayerConnectionPatch;
import javassist.ClassPool;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by psygate on 17.06.2016.
 */
public class GrandUnifiedPatcher {
    private static GrandUnifiedPatcher instance;
    private boolean init = false;
    private List<Patch> patches = new LinkedList<>();
    private ClassPool pool;

    private GrandUnifiedPatcher() {
        pool = ClassPool.getDefault();
        patches.add(new PlayerConnectionPatch());
    }

    public static GrandUnifiedPatcher getInstance() {
        if (instance == null) {
            instance = new GrandUnifiedPatcher();
        }

        return instance;
    }

    public void init() {
        if (!init) {
            init = true;
            try {
                patchAll();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void patchAll() {
        for (Patch patch : patches) {
            try {
                patch.run(pool);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }
}
