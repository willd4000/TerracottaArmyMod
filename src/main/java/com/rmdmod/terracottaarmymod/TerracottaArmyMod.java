package com.rmdmod.terracottaarmymod;

import com.mojang.logging.LogUtils;
import com.rmdmod.terracottaarmymod.block.ModBlocks;
import com.rmdmod.terracottaarmymod.fluid.ModFluidTypes;
import com.rmdmod.terracottaarmymod.fluid.ModFluids;
import com.rmdmod.terracottaarmymod.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TerracottaArmyMod.MOD_ID)
public class TerracottaArmyMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "terracottaarmymod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public TerracottaArmyMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModFluids.register((modEventBus));
        ModFluidTypes.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the addCreative method for modloading
        //modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::buildContents);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);



    }
    public void buildContents(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(MOD_ID, "example"), builder ->
                // Set name of tab to display
                builder.title(Component.translatable("Diversity Mod Items"))
                        // Set icon of creative tab
                        .icon(() -> new ItemStack(ModItems.BOWL_OF_STEAMED_RICE.get()))
                        // Add default items to tab
                        .displayItems((enabledFlags, populator, hasPermissions) -> {
                            populator.accept(ModItems.JADE_SHARD.get());
                            populator.accept(ModItems.MERCURY_BUCKET.get());
                            populator.accept(ModItems.BOWL_OF_WINE.get());
                            populator.accept(ModBlocks.RICE.get());
                            populator.accept(ModItems.BOWL_OF_STEAMED_RICE.get());
                            populator.accept(ModItems.MINITE_SPEAR.get());


                        })
        );
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            //ModVillagers.registerPOIs();;
        });
    }




    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            //ItemBlockRenderTypes.setRenderLayer(ModBlocks.SLIMEY_BERRY_CROP_BLOCK.get(), RenderType.cutout());
            // note that the above line is no longer necessary, so long that the render type is defined in the stage json files
//            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_MERCURY.get(), RenderType.translucent());
//            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_MERCURY.get(), RenderType.translucent());
        }
    }
}
