package extracells.block;

import extracells.Extracells;
import extracells.tileentity.TileEntityCraftingStorage;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class BlockCraftingStorage extends appeng.block.crafting.BlockCraftingStorage {

	private static IIcon[] icons = new IIcon[8];

	public BlockCraftingStorage() {
		this.setTileEntity(TileEntityCraftingStorage.class);
        this.setCreativeTab(Extracells.ModTab());
		this.hasSubtypes = true;
		this.setBlockName("blockCraftingStorage");
	}

	@Override
	public String getUnlocalizedName( ItemStack is ){
		return this.getItemUnlocalizedName( is );
	}

	protected String getItemUnlocalizedName( ItemStack is ){
		return super.getUnlocalizedName( is );
	}

    public void registerBlockIcons(IIconRegister ir) {
        icons[0] = ir.registerIcon("extracells:crafting.storage.256k");
        icons[1] = ir.registerIcon("extracells:crafting.storage.256k.fit");

        icons[2] = ir.registerIcon("extracells:crafting.storage.1024k");
        icons[3] = ir.registerIcon("extracells:crafting.storage.1024k.fit");

        icons[4] = ir.registerIcon("extracells:crafting.storage.4096k");
        icons[5] = ir.registerIcon("extracells:crafting.storage.4096k.fit");

        icons[6] = ir.registerIcon("extracells:crafting.storage.16384k");
        icons[7] = ir.registerIcon("extracells:crafting.storage.16384k.fit");

	//	icons[7] = ir.registerIcon("extracells:crafting.storage.65536k");
	//	icons[8] = ir.registerIcon("extracells:crafting.storage.65536k.fit");

	//	icons[9] = ir.registerIcon("extracells:crafting.storage.262144k");
	//	icons[10] = ir.registerIcon("extracells:crafting.storage.262144k.fit");

	//	icons[11] = ir.registerIcon("extracells:crafting.storage.1048576k");
	//	icons[12] = ir.registerIcon("extracells:crafting.storage.1048576k.fit");

    }

	@Override
	public IIcon getIcon(int side, int meta) {
		switch(meta & (~4)){
			case 0: return icons[0];
			case 1: return icons[2];
			case 2: return icons[4];
			case 3: return icons[6];
			case 8: return icons[1];
			case 1|8: return icons[3];
			case 2|8: return icons[5];
			case 3|8: return icons[7];
			//case 4|8: return icons[8];
			//case 5|8: return icons[9];
			//case 6|8: return icons[10];
			default: return null;
		}
	}
}
