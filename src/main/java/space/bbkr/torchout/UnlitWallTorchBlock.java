package space.bbkr.torchout;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class UnlitWallTorchBlock extends WallTorchBlock {
	protected UnlitWallTorchBlock(Settings settings, ParticleEffect particleEffect) {
		super(settings, particleEffect);
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		ItemStack stack = player.getStackInHand(hand);
		if (stack.getItem() == Items.FLINT_AND_STEEL && !world.isClient) {
			if (state.getBlock() == TorchOut.UNLIT_WALL_TORCH) {
				stack.damage(1, player, p -> player.sendToolBreakStatus(hand));
				world.setBlockState(pos, Blocks.WALL_TORCH.getDefaultState().with(WallTorchBlock.FACING, state.get(WallTorchBlock.FACING)));
				world.playSound(null, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1F, 1F);
				return ActionResult.SUCCESS;
			} else if (state.getBlock() == TorchOut.UNLIT_SOUL_WALL_TORCH) {
				stack.damage(1, player, p -> player.sendToolBreakStatus(hand));
				world.setBlockState(pos, Blocks.SOUL_WALL_TORCH.getDefaultState().with(WallTorchBlock.FACING, state.get(WallTorchBlock.FACING)));
				world.playSound(null, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1F, 1F);
				return ActionResult.SUCCESS;
			}
		}
		return ActionResult.FAIL;
	}

	@Override
	public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
		//NO-OP
	}

	@Override
	public boolean hasRandomTicks(BlockState state) {
		return false;
	}
}
