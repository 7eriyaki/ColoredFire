package com.software.ddk.coloredfire.common.block.dyeable;

import com.software.ddk.coloredfire.common.block.GenericFireBlock;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.world.BlockView;

public class DyeableFireBlock extends GenericFireBlock implements BlockEntityProvider {
    private int COLOR = 0xffffff;

    public DyeableFireBlock() {
        super(StatusEffects.INSTANT_DAMAGE, 0xffffff, 8, 1, 1);
        this.setEffect(false);
    }

    public int getCOLOR(){
        return COLOR;
    }

    public void setCOLOR(int COLOR){
        this.COLOR = COLOR;
    }

    @Override
    public BlockEntity createBlockEntity(BlockView view) {
        DyeableFireBlockEntity blockEntity = new DyeableFireBlockEntity();
        blockEntity.setCOLOR(COLOR);
        return blockEntity;
    }
}
