package space.bbkr.torchout.mixin;

import java.util.Random;

import org.spongepowered.asm.mixin.Mixin;
import space.bbkr.torchout.TorchOut;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TorchBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;

@Mixin(TorchBlock.class)
public abstract class MixinTorchBlock extends Block {
	public MixinTorchBlock(Settings settings) {
		super(settings);
	}

	@Override
	public boolean hasRandomTicks(BlockState state) {
		return true;
	}

	@Override
	public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
		if (random.nextInt(20) == 0 || (world.isRaining() && world.isSkyVisible(pos) && random.nextInt(5) == 0)) {
			if (state.getBlock() == Blocks.TORCH) {
				world.setBlockState(pos, TorchOut.UNLIT_TORCH.getDefaultState());
				world.playSound(null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1F, 1F);
			} else if (state.getBlock() == Blocks.SOUL_TORCH) {
				world.setBlockState(pos, TorchOut.UNLIT_SOUL_TORCH.getDefaultState());
				world.playSound(null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 1F, 1F);
			}
		}
	}
}
