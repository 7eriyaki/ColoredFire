package com.software.ddk.coloredfire.common.block.torch;

import com.software.ddk.coloredfire.ModContent;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.CompoundTag;

public class GenericTorchBlockEntity extends BlockEntity implements BlockEntityClientSerializable {
    private int COLOR;

    public void setCOLOR(int COLOR) {
        this.COLOR = COLOR;
        markDirty();
    }

    public int getCOLOR() {
        return COLOR;
    }

    public GenericTorchBlockEntity() {
        super(ModContent.GENERIC_TORCH_BLOCK_ENTITY);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        tag.putInt("color", COLOR);
        return tag;
    }

    @Override
    public void fromTag(BlockState blockState, CompoundTag tag) {
        super.fromTag(blockState, tag);
        COLOR = tag.getInt("color");
    }

    @Override
    public void fromClientTag(CompoundTag tag) {
        COLOR = tag.getInt("color");
    }

    @Override
    public CompoundTag toClientTag(CompoundTag tag) {
        tag.putInt("color", COLOR);
        return tag;
    }
}
