package com.sp.block;

import com.sp.init.ModSounds;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class SprintBlockSoundGroup extends BlockSoundGroup {
    private final SoundEvent sprintSound;

    public static final SprintBlockSoundGroup SILENT = new SprintBlockSoundGroup(
            0.0f,
            0.0f,
            ModSounds.SILENCE,
            ModSounds.SILENCE,
            ModSounds.SILENCE,
            ModSounds.SILENCE,
            ModSounds.SILENCE,
            ModSounds.SILENCE
    );

    public static final SprintBlockSoundGroup CARPET = new SprintBlockSoundGroup(
            1.0f,
            1.0f,
            SoundEvents.BLOCK_WOOL_BREAK,
            ModSounds.CARPET_WALK,
            SoundEvents.BLOCK_WOOL_PLACE,
            ModSounds.SILENCE,
            ModSounds.CARPET_RUN,
            ModSounds.CARPET_RUN
    );

    public static final SprintBlockSoundGroup CONCRETE = new SprintBlockSoundGroup(
            1.0f,
            1.0f,
            SoundEvents.BLOCK_STONE_BREAK,
            ModSounds.CONCRETE_WALK,
            SoundEvents.BLOCK_STONE_PLACE,
            ModSounds.SILENCE,
            ModSounds.CONCRETE_RUN,
            ModSounds.CONCRETE_RUN
    );

    public static final BlockSoundGroup WALL = new BlockSoundGroup(
            1.0f,
            1.0f,
            SoundEvents.BLOCK_WOOD_BREAK,
            SoundEvents.BLOCK_WOOD_STEP,
            SoundEvents.BLOCK_WOOD_PLACE,
            ModSounds.SILENCE,
            SoundEvents.BLOCK_WOOD_FALL
    );

    public static final BlockSoundGroup CEILING_TILE = new BlockSoundGroup(
            1.0f,
            1.0f,
            SoundEvents.BLOCK_WOOD_BREAK,
            SoundEvents.BLOCK_WOOD_STEP,
            SoundEvents.BLOCK_WOOD_PLACE,
            ModSounds.SILENCE,
            SoundEvents.BLOCK_WOOD_FALL
    );

    public static final BlockSoundGroup GRASS2 = new SprintBlockSoundGroup(
            1.0f,
            1.0f,
            SoundEvents.BLOCK_GRASS_BREAK,
            ModSounds.GRASS_WALK,
            SoundEvents.BLOCK_GRASS_PLACE,
            ModSounds.SILENCE,
            ModSounds.GRASS_RUN,
            ModSounds.GRASS_RUN
    );

    public SprintBlockSoundGroup(float volume, float pitch, SoundEvent breakSound, SoundEvent stepSound, SoundEvent placeSound, SoundEvent hitSound, SoundEvent fallSound, SoundEvent sprintSound) {
        super(volume, pitch, breakSound, stepSound, placeSound, hitSound, fallSound);
        this.sprintSound = sprintSound;
    }

    public SoundEvent getSprintingSound(){
        return this.sprintSound;
    }

}
