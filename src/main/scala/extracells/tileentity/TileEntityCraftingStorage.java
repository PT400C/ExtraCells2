package extracells.tileentity;

import appeng.tile.crafting.TileCraftingStorageTile;
import appeng.tile.crafting.TileCraftingTile;
import net.minecraft.item.ItemStack;

import static extracells.registries.BlockEnum.CRAFTINGSTORAGE;

public class TileEntityCraftingStorage extends TileCraftingStorageTile {

	private static final int KILO_SCALAR = 1024;

	@Override
	protected ItemStack getItemFromTile( final Object obj ){
		final int storage = ((TileCraftingTile) obj).getStorageBytes() / KILO_SCALAR;

		switch(storage){
			case 256:  return new ItemStack(CRAFTINGSTORAGE.getBlock(), 1, 0);
			case 1024: return new ItemStack(CRAFTINGSTORAGE.getBlock(), 1, 1);
			case 4096: return new ItemStack(CRAFTINGSTORAGE.getBlock(), 1, 2);
			case 16384: return new ItemStack(CRAFTINGSTORAGE.getBlock(), 1, 3);
			case 65536: return new ItemStack(CRAFTINGSTORAGE.getBlock(), 1, 4);
			case 262144: return new ItemStack(CRAFTINGSTORAGE.getBlock(), 1, 5);
			case 1048576: return new ItemStack(CRAFTINGSTORAGE.getBlock(), 1, 6);
		}
		return super.getItemFromTile(obj);
	}

	@Override
	public int getStorageBytes(){
		if (this.worldObj == null || this.notLoaded()) return 0;

		switch (this.blockMetadata & 3) {
            case 0: return 256 * KILO_SCALAR;
            case 1: return 1024 * KILO_SCALAR;
            case 2: return 4096 * KILO_SCALAR;
            case 3: return 16384 * KILO_SCALAR;
			case 4: return 65536 * KILO_SCALAR;
			case 5: return 262144 * KILO_SCALAR;
			case 6: return 1048576 * KILO_SCALAR;
			default: return 0;
		}
	}
}
