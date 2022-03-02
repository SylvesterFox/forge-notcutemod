package com.sylvesternotcute.notcutesign.init;

import com.sylvesternotcute.notcutesign.MainMod;
import com.sylvesternotcute.notcutesign.entity.SeatEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitEntities
{
    public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, MainMod.MOD_ID);

    public static final RegistryObject<EntityType<SeatEntity>> SEAT = register("seat", EntityType.Builder.<SeatEntity>of((type, world) -> new SeatEntity(world), EntityClassification.MISC).sized(0.0f, 0.0f).setCustomClientFactory(((spawnEntity, world) -> new SeatEntity(world))));

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, EntityType.Builder<T> builder){
        return REGISTER.register(name, () -> builder.build(name));
    }
}
