package com.rmdmod.terracottaarmymod.fluid;
import com.rmdmod.terracottaarmymod.TerracottaArmyMod;
import com.rmdmod.terracottaarmymod.block.ModBlocks;
import com.rmdmod.terracottaarmymod.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, TerracottaArmyMod.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_MERCURY = FLUIDS.register("source_mercury",
            () -> new ForgeFlowingFluid.Source(ModFluids.MERCURY_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_MERCURY = FLUIDS.register("flowing_mercury",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.MERCURY_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties MERCURY_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.MERCURY_FLUID_TYPE, SOURCE_MERCURY, FLOWING_MERCURY)
            .slopeFindDistance(2).levelDecreasePerBlock(2).block(ModBlocks.MERCURY_BLOCK)
            .bucket(ModItems.MERCURY_BUCKET);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}