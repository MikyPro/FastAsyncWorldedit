package com.boydti.fawe.sponge.v1_12;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

import java.util.Arrays;

public class MutableGenLayer extends GenLayer {

    private int biome;

    public MutableGenLayer(long seed) {
        super(seed);
    }

    public MutableGenLayer set(int biome) {
        this.biome = biome;
        return this;
    }

    @Override
    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight) {
        int[] biomes = IntCache.getIntCache(areaWidth * areaHeight);
        Arrays.fill(biomes, biome);
        return biomes;
    }
}
