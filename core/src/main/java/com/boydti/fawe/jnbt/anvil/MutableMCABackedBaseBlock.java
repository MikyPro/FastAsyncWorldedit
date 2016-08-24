package com.boydti.fawe.jnbt.anvil;

import com.boydti.fawe.FaweCache;
import com.sk89q.jnbt.CompoundTag;
import com.sk89q.worldedit.blocks.BaseBlock;
import javax.annotation.Nullable;

/**
 * I'm aware this isn't OOP, but object creation is expensive
 */
public class MutableMCABackedBaseBlock extends BaseBlock {

    private MCAChunk chunk;
    private byte[] data;
    private byte[] ids;
    private int index;
    private int x;
    private int y;
    private int z;

    public MutableMCABackedBaseBlock() {
        super(0);
    }

    public void setChunk(MCAChunk chunk) {
        this.chunk = chunk;
    }

    public void setArrays(int layer) {
        data = chunk.data[layer];
        ids = chunk.ids[layer];
    }

    public void setIndex(int x, int y, int z, int index) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.index = index;
    }

    @Override
    public int getId() {
        return ids[index] & 0xFF;
    }

    @Override
    public int getData() {
        if (!FaweCache.hasData(ids[index])) {
            return 0;
        } else {
            int indexShift = index >> 1;
            if ((index & 1) == 0) {
                return data[index] & 15;
            } else {
                return data[index] >> 4 & 15;
            }
        }
    }

    @Nullable
    @Override
    public CompoundTag getNbtData() {
        return chunk.getTile(x, y, z);
    }

    @Override
    public void setId(int id) {
        ids[index] = (byte) id;
        chunk.setModified();
    }

    @Override
    public void setData(int value) {
        int indexShift = index >> 1;
        if((index & 1) == 0) {
            data[indexShift] = (byte)(data[indexShift] & 240 | value & 15);
        } else {
            data[indexShift] = (byte)(data[indexShift] & 15 | (value & 15) << 4);
        }
        chunk.setModified();
    }

    @Override
    public void setNbtData(@Nullable CompoundTag nbtData) {
        chunk.setTile(x, y, z, null);
        chunk.setModified();
    }
}