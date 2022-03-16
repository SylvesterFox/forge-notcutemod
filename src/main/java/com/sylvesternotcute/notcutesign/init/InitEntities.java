package com.sylvesternotcute.notcutesign.init;

import com.sylvesternotcute.notcutesign.MainMod;
import com.sylvesternotcute.notcutesign.entity.SeatEntity;
import com.sylvesternotcute.notcutesign.entity.custom.FennecFoxEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class InitEntities
{
    public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, MainMod.MOD_ID);

    public static final RegistryObject<EntityType<SeatEntity>> SEAT = register_seat("seat",
            EntityType.Builder.<SeatEntity>of((type, world) -> new SeatEntity(world), EntityClassification.MISC).sized(0.0f, 0.0f).setCustomClientFactory(((spawnEntity, world) -> new SeatEntity(world))));


    private static <T extends Entity> RegistryObject<EntityType<T>> register_seat(String name, EntityType.Builder<T> builder){
        return REGISTER.register(name, () -> builder.build(name));
    }

//    public static final RegistryObject<EntityType<TestMobEntity>> TEST_MOB = REGISTER.register("test_mob", () ->
//            EntityType.Builder.of(TestMobEntity::new, EntityClassification.CREATURE).sized(.5f, .5f)
//                    .setShouldReceiveVelocityUpdates(false)
//                    .build("test_mob"));

    public static final RegistryObject<EntityType<FennecFoxEntity>> FENNEC_FOX = REGISTER.register("fennec_fox", () ->
            EntityType.Builder.of(FennecFoxEntity::new, EntityClassification.CREATURE).sized(0.6f, 0.7f).build("fennec_fox"));

}
