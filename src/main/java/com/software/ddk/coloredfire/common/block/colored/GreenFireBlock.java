package com.software.ddk.coloredfire.common.block.colored;

import com.software.ddk.coloredfire.common.block.GenericFireBlock;
import net.minecraft.entity.effect.StatusEffects;

public class GreenFireBlock extends GenericFireBlock {
    public static final int COLOR = 0xDD32F224;

    public GreenFireBlock() {
        super(StatusEffects.POISON, COLOR, 400, 200, 40);
    }
}
