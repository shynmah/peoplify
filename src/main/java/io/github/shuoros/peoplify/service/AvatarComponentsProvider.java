package io.github.shuoros.peoplify.service;

import io.github.shuoros.peoplify.model.*;
import io.github.shuoros.peoplify.model.enumeration.*;
import org.springframework.util.ResourceUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AvatarComponentsProvider {

    protected static final Map<BodyColor, BodyComponent> body;
    protected static final Map<FaceType, FaceComponent> face;
    protected static final Map<HairType, HairComponent> hair;
    protected static final Map<BeardType, HairComponent> beard;
    protected static final Map<MustacheType, HairComponent> mustache;
    protected static final Map<AccessoryColor, ClothComponent> cloth;
    protected static final Map<GlassesType, AccessoryComponent> glasses;
    protected static final List<OtherComponent> earing;
    protected static OtherComponent mole;
    protected static OtherComponent headband;
    protected static OtherComponent scar;
    protected static OtherComponent tattoo;

    static {
        body = Map.of(
                BodyColor.YELLOW, buildBodyComponent("body-yellow"),
                BodyColor.BLACK, buildBodyComponent("body-black"),
                BodyColor.BROWN, buildBodyComponent("body-brown"),
                BodyColor.NUDE, buildBodyComponent("body-nude"),
                BodyColor.PINK, buildBodyComponent("body-pink"),
                BodyColor.WHITE, buildBodyComponent("body-white")
        );
        face = Map.of(
                FaceType.NORMAL, buildFaceComponent("face-normal"),
                FaceType.FRECKLES, buildFaceComponent("face-freckles")
        );
        hair = Map.of(
                HairType.SEMI_BALD, buildHairComponent("hair-semi-bald", 170, 100),
                HairType.LONG_AFRO, buildHairComponent("hair-long-afro", 57, 10),
                HairType.SHORT_AFRO, buildHairComponent("hair-short-afro", 100, 0),
                HairType.PONY_TAIL, buildHairComponent("hair-pony-tail", 169, 10),
                HairType.CENTER_PART, buildHairComponent("hair-center-part", 174, 44),
                HairType.SIDE_PART, buildHairComponent("hair-side-part", 174, 44),
                HairType.CORNROWS, buildHairComponent("hair-cornrows", 140, 0),
                HairType.BALD, buildHairComponent("hair-bald", 235, 55)
        );
        beard = Map.of(
                BeardType.GOAT_PATCH, buildHairComponent("beard-goat-patch", 277, 360),
                BeardType.GOATEE, buildHairComponent("beard-goatee", 285, 360),
                BeardType.FORK, buildHairComponent("beard-fork", 271, 355),
                BeardType.CHIN_TRAP, buildHairComponent("beard-chin-trap", 161, 267),
                BeardType.GARIBALDI, buildHairComponent("beard-garibaldi", 161, 280),
                BeardType.NED_KELLY, buildHairComponent("beard-ned-kelly", 174, 250)
        );
        mustache = Map.of(
                MustacheType.CHEVRON, buildHairComponent("mustache-chevron", 254, 268),
                MustacheType.WALRUS, buildHairComponent("mustache-walrus", 254, 268),
                MustacheType.HANDLEBAR, buildHairComponent("mustache-handlebar", 254, 268),
                MustacheType.POIROT, buildHairComponent("mustache-poirot", 272, 276)
        );
        cloth = Map.of(
                AccessoryColor.BLACK, buildClothComponent("cloth-black"),
                AccessoryColor.BLUE, buildClothComponent("cloth-blue"),
                AccessoryColor.GRAY, buildClothComponent("cloth-gray"),
                AccessoryColor.GREEN, buildClothComponent("cloth-green"),
                AccessoryColor.ORANGE, buildClothComponent("cloth-orange"),
                AccessoryColor.PINK, buildClothComponent("cloth-pink"),
                AccessoryColor.PURPLE, buildClothComponent("cloth-purple"),
                AccessoryColor.RED, buildClothComponent("cloth-red"),
                AccessoryColor.WHITE, buildClothComponent("cloth-white"),
                AccessoryColor.YELLOW, buildClothComponent("cloth-yellow")
        );
        glasses = Map.of(
                GlassesType.ROUND, buildAccessoryComponent("glasses-round", 170, 166),
                GlassesType.CAT_EYE, buildAccessoryComponent("glasses-cat-eye", 152, 154)
        );
        earing = List.of(
                buildOtherComponent("earing-0", 154, 264),
                buildOtherComponent("earing-0", 429, 264),
                buildOtherComponent("earing-1", 154, 265)
        );
        mole = buildOtherComponent("mole", 330, 250);
        headband = buildOtherComponent("headband", 176, 110);
        scar = buildOtherComponent("scar", 240, 140);
        tattoo = buildOtherComponent("tattoo", 435, 540);
    }

    private static BodyComponent buildBodyComponent(String name) {
        return BodyComponent.builder()
                .image(loadImage(name))
                .build();
    }

    private static FaceComponent buildFaceComponent(String name) {
        return FaceComponent.builder()
                .image(loadImage(name))
                .build();
    }

    private static HairComponent buildHairComponent(String name, Integer x, Integer y) {
        return HairComponent.builder()
                .hairs(
                        Map.of(
                                HairColor.BLACK, loadImage(name + "-black"),
                                HairColor.BLONDE, loadImage(name + "-blonde"),
                                HairColor.BLUE, loadImage(name + "-blue"),
                                HairColor.BROWN, loadImage(name + "-brown"),
                                HairColor.ORANGE, loadImage(name + "-orange"),
                                HairColor.PINK, loadImage(name + "-pink"),
                                HairColor.WHITE, loadImage(name + "-white")
                        )
                )
                .x(x)
                .y(y)
                .build();
    }

    private static AccessoryComponent buildAccessoryComponent(String name, Integer x, Integer y) {
        return AccessoryComponent.builder()
                .colors(
                        Map.of(
                                AccessoryColor.BLACK, loadImage(name + "-black"),
                                AccessoryColor.BLUE, loadImage(name + "-blue"),
                                AccessoryColor.GRAY, loadImage(name + "-gray"),
                                AccessoryColor.GREEN, loadImage(name + "-green"),
                                AccessoryColor.ORANGE, loadImage(name + "-orange"),
                                AccessoryColor.PINK, loadImage(name + "-pink"),
                                AccessoryColor.PURPLE, loadImage(name + "-purple"),
                                AccessoryColor.RED, loadImage(name + "-red"),
                                AccessoryColor.WHITE, loadImage(name + "-white"),
                                AccessoryColor.YELLOW, loadImage(name + "-yellow")
                                )
                )
                .x(x)
                .y(y)
                .build();
    }

    private static ClothComponent buildClothComponent(String name) {
        return ClothComponent.builder()
                .image(loadImage(name))
                .build();
    }

    private static OtherComponent buildOtherComponent(String name, Integer x, Integer y) {
        return OtherComponent.builder()
                .image(loadImage(name))
                .x(x)
                .y(y)
                .build();
    }

    private static BufferedImage loadImage(String name) {
        try {
            return ImageIO.read(ResourceUtils.getFile("classpath:static/components/" + name + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
