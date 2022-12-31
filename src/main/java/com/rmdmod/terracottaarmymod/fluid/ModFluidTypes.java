package com.rmdmod.terracottaarmymod.fluid;

import com.rmdmod.terracottaarmymod.TerracottaArmyMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

public class ModFluidTypes {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation MERCURY_OVERLAY_RL = new ResourceLocation(TerracottaArmyMod.MOD_ID, "misc/in_mercury");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, TerracottaArmyMod.MOD_ID);

    public static final RegistryObject<FluidType> MERCURY_FLUID_TYPE = register("mercury_fluid",
            FluidType.Properties.create().density(25).viscosity(5).supportsBoating(true).sound(SoundAction.get("drink"),
                    SoundEvents.HONEY_DRINK));



    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, MERCURY_OVERLAY_RL,
                0xFF454545, new Vector3f(60f / 255f, 60f / 255f, 60f / 255f), properties));
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}