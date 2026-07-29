# Batman Capes

[![Modrinth Downloads Badge](https://img.shields.io/modrinth/dt/CbOyCTIt?style=for-the-badge&logo=modrinth&color=%2300AF5C&link=https%3A%2F%2Fmodrinth.com%2Fmod%2Fbatman-capes)](https://modrinth.com/mod/batman-capes) [![CurseForge Downloads Badge](https://img.shields.io/curseforge/dt/IDCURSEFORGE?style=for-the-badge&logo=curseforge&color=F16436)](https://www.curseforge.com/minecraft/mc-mods/batman-capes)

<img src="https://raw.githubusercontent.com/TheoDgb/BatmanCapes/main/media/batman_capes_icon.png" alt="Batman Capes Icon" width="10%">

## About
This mod adds Batman elytra capes, including custom cape items, crafting recipes, animated models, and unique textures.

## Cape Showcase
<table>
  <tbody>
    <tr>
      <td>
        <img src="https://raw.githubusercontent.com/TheoDgb/BatmanCapes/main/media/gif/batman_capes_batman_crouching.gif" alt="Batman's cape unfolding, rear view">
      </td>
      <td>
        <img src="https://raw.githubusercontent.com/TheoDgb/BatmanCapes/main/media/gif/batman_capes_batgirl_crouching.gif" alt="Batgirl's cape unfolding, front view">
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <img src="https://raw.githubusercontent.com/TheoDgb/BatmanCapes/main/media/gif/batman_capes_gliding_through_the_city.gif" alt="Batman's cape gliding through the city" width="100%">
      </td>
    </tr>
  </tbody>
</table>

## Cape Items
<img src="https://raw.githubusercontent.com/TheoDgb/BatmanCapes/main/media/cape_crafting/cape_crafting.gif" alt="Animated preview of Batman elytra cape crafting recipes" width="50%">

## Supported Platforms and Dependencies
### Fabric (Minecraft 26.2)
- [Fabric API](https://modrinth.com/mod/fabric-api)
- [GeckoLib](https://modrinth.com/mod/geckolib)
- [Elytra Physics](https://modrinth.com/mod/elytra-physics) (recommended)

### NeoForge (Minecraft 26.2)
- [GeckoLib](https://modrinth.com/mod/geckolib)
- [Elytra Physics](https://modrinth.com/mod/elytra-physics) (recommended)

## Elytra Physics Integration
To make Batman capes work with the Elytra Physics mod, edit `.minecraft/config/elytra-physics-config.json` and add the following entry to the `inject_layers` array:
```
{
    "inject_layers": [
        "com.allium.batmancapes.client.renderer.layer.BatmanCapeElytraLayer"
    ]
}
```

## Vanilla Give Commands
Note: The item ID naming is based on the costume the cape is designed to match, not the cape itself.
```
/give @s batmancapes:batman_cape
/give @s batmancapes:black_and_gray_cape
/give @s batmancapes:blue_and_gray_cape
/give @s batmancapes:btas_cape
/give @s batmancapes:city_cape
/give @s batmancapes:first_appearance_cape
/give @s batmancapes:flashpoint_cape
/give @s batmancapes:knight_cape
/give @s batmancapes:pattinson_cape
```

## License
The source code of this mod is licensed under the MIT License.<br>
Third-party assets (models and textures) are not covered by this license and remain the property of their respective authors.

## Batman Cape Model Credits
### Batman Suits & Capes Minecraft Texture Pack
Author: LeviTheReclaimed<br>
Source: https://www.planetminecraft.com/texture-pack/batman-suits-capes/<br>
Assets used: 3D cape model and cape textures.<br>
Usage terms: Credit required by the author.<br>
Modified: Adapted the model for Minecraft, including new animations.

<img src="https://raw.githubusercontent.com/TheoDgb/BatmanCapes/main/media/gif/batman_capes_gliding_across_the_city.gif" alt="Batman's cape gliding across the city" width="100%">