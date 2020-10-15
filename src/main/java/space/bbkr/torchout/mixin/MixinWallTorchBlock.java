package space.bbkr.torchout.mixin;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import space.bbkr.torchout.TorchOut;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;

@Mixin(WallTorchBlock.class)
public abstract class MixinWallTorchBlock extends Block {
	public MixinWallTorchBlock(Settings settings) {
		super(settings);
	}

	@Override
	public boolean hasRandomTicks(BlockState state) {
		return true;
	}

	@Override
	public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		if (random.nextInt(20) == 0 || (world.isRaining() && world.isSkyVisible(pos) && random.nextInt(5) == 0)) {
			if (state.getBlock() == Blocks.WALL_TORCH) {
				world.setBlockState(pos, TorchOut.UNLIT_WALL_TORCH.getDefaultState().with(WallTorchBlock.FACING, state.get(WallTorchBlock.FACING)));
				world.playSound(null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1F, 1F);
			} else if (state.getBlock() == Blocks.SOUL_WALL_TORCH) {
				world.setBlockState(pos, TorchOut.UNLIT_SOUL_WALL_TORCH.getDefaultState().with(WallTorchBlock.FACING, state.get(WallTorchBlock.FACING)));
				world.playSound(null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1F, 1F);
			}
		}
	}
}
