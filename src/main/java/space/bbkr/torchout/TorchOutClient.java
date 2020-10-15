package space.bbkr.torchout;

import net.minecraft.client.render.RenderLayer;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;

public class TorchOutClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), TorchOut.UNLIT_TORCH, TorchOut.UNLIT_SOUL_TORCH,
				TorchOut.UNLIT_WALL_TORCH, TorchOut.UNLIT_SOUL_WALL_TORCH);
	}
}
