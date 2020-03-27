package com.software.ddk.coloredfire.common.item;

import com.software.ddk.coloredfire.ModContent;
import com.software.ddk.coloredfire.common.block.colored.GreenFireBlock;
import com.software.ddk.coloredfire.common.material.GenericToolMaterial;
import net.minecraft.advancement.criterion.Criterions;
import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.IWorld;

public class GenericFlintAndSteel extends ToolItem {
    public GenericFlintAndSteel(Settings item$Settings) {
        super(GenericToolMaterial.FLINT_TOOL_MATERIAL, item$Settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext itemUsageContext_1) {
        //default color green, need to override this example code.
        //sendBreakStatus(itemUsageContext_1);
        return onUse(itemUsageContext_1, ((GreenFireBlock) ModContent.GREEN_FIRE_BLOCK).getStateForPosition(getContextIworld(itemUsageContext_1), getContextBlockPos(itemUsageContext_1)));
    }

    protected ActionResult onUse(ItemUsageContext context, BlockState state){
        PlayerEntity player = context.getPlayer();
        IWorld iworld = getContextIworld(context);
        BlockPos pos = getContextBlockPos(context);

        if (canIgnite(iworld.getBlockState(pos), iworld, pos)) {
            this.playSound(iworld, player, pos);
            iworld.setBlockState(pos, state, 11);
            ItemStack stack = context.getStack();
            if (player instanceof ServerPlayerEntity) {
                Criterions.PLACED_BLOCK.trigger((ServerPlayerEntity)player, pos, stack);
                stack.damage(1, (LivingEntity)player, ((playerx) -> playerx.sendToolBreakStatus(context.getHand())));
            }
            return ActionResult.SUCCESS;
        } else {
            state = iworld.getBlockState(pos);
            if (isIgnitable(state)) {
                this.playSound(iworld, player, pos);
                iworld.setBlockState(pos, (BlockState)state.with(Properties.LIT, true), 11);
                if (player != null) {
                    context.getStack().damage(1, (LivingEntity)player, ((playerEntity_1x) -> playerEntity_1x.sendToolBreakStatus(context.getHand())));
                }
                return ActionResult.SUCCESS;
            } else {
                return ActionResult.FAIL;
            }
        }
    }

    private void playSound(IWorld iworld, PlayerEntity player, BlockPos pos){
        iworld.playSound(player, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, RANDOM.nextFloat() * 0.4F + 0.8F);
    }

    protected IWorld getContextIworld(ItemUsageContext itemUsageContext){
        return itemUsageContext.getWorld();
    }

    protected BlockPos getContextBlockPos(ItemUsageContext itemUsageContext){
        return itemUsageContext.getBlockPos().offset(itemUsageContext.getSide());
    }

    private static boolean isIgnitable(BlockState blockState_1) {
        return blockState_1.getBlock() == Blocks.CAMPFIRE &&
                !(Boolean)blockState_1.get(Properties.WATERLOGGED) &&
                !(Boolean)blockState_1.get(Properties.LIT);
    }

    private static boolean canIgnite(BlockState state, IWorld world, BlockPos pos) {
        //todo nether portal ignite is disabled
        BlockState blockState_2 = AbstractFireBlock.getState(world, pos);
        boolean boolean_1 = false;
        for (Direction direction_1 : Direction.Type.HORIZONTAL) {
            if (world.getBlockState(pos.offset(direction_1)).getBlock() == Blocks.OBSIDIAN &&
                    ((NetherPortalBlock) Blocks.NETHER_PORTAL).createAreaHelper(world, pos) != null) {
                boolean_1 = true;
            }
        }
        return state.isAir() && (blockState_2.canPlaceAt(world, pos) || boolean_1);
    }

}
