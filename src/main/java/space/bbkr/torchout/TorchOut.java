package space.bbkr.torchout;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TorchOut implements ModInitializer {
	public static final String MODID = "torchout";

	public static final Block UNLIT_TORCH = Registry.register(Registry.BLOCK, new Identifier(MODID, "unlit_torch"),
			new UnlitTorchBlock(FabricBlockSettings.copy(Blocks.TORCH).dropsLike(Blocks.TORCH)
					.luminance(state -> 0), ParticleTypes.FLAME));

	public static final Block UNLIT_SOUL_TORCH = Registry.register(Registry.BLOCK, new Identifier(MODID, "unlit_soul_torch"),
			new UnlitTorchBlock(FabricBlockSettings.copy(Blocks.SOUL_TORCH).dropsLike(Blocks.SOUL_TORCH)
					.luminance(state -> 0), ParticleTypes.SOUL_FIRE_FLAME));

	public static final Block UNLIT_WALL_TORCH = Registry.register(Registry.BLOCK, new Identifier(MODID, "unlit_wall_torch"),
			new UnlitWallTorchBlock(FabricBlockSettings.copy(Blocks.WALL_TORCH).dropsLike(Blocks.WALL_TORCH)
					.luminance(state -> 0), ParticleTypes.FLAME));

	public static final Block UNLIT_SOUL_WALL_TORCH = Registry.register(Registry.BLOCK, new Identifier(MODID, "unlit_soul_wall_torch"),
			new UnlitWallTorchBlock(FabricBlockSettings.copy(Blocks.SOUL_WALL_TORCH).dropsLike(Blocks.SOUL_WALL_TORCH)
					.luminance(state -> 0), ParticleTypes.SOUL_FIRE_FLAME));

	@Override
	public void onInitialize() {

	}
}
