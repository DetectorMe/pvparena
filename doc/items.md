
If you are brave, you can set items for inventories or enhancements directly in 
arena config files. It's quite verbose but not really hard. If you aren't at ease with YAML
config files, please use [/pa class](commands/class.md) commands.

JavaDoc : [Bukkit Material ENUMs](https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Material.html)

## Create a simple item list:

In order to create a basic list of items (without enchant or any enhancements), create a simple
YAML list with two keys : "type" and "amount".

"Type" is the items name, it **must be** from the material enum page - *cf. above link*

"amount" is the number of items you want to give. *This parameter is optional and,
 if not set, equals to 1 (and 64 for arrows)*
 
#### Example:

```yaml
items:
    - type: BOW
    - type: ARROW
      amount: 64
    - type: IRON_SWORD
    - type: COOKED_BEEF
      amount: 2
```

## Create an advanced item list

The principle is the same, you just have to add a **meta** key to list items and add the good 
properties.

### Enchantments

You can add enchantments according the following instance. The enchantment names must be picked
from this page : [Bukkit enchantments](https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/enchantments/Enchantment.html) 

```yaml
  myclassname:
    items:
    - type: IRON_SWORD
      meta:
        enchants:
          DURABILITY: 3
          KNOCKBACK: 1
    offhand:
    - type: SHIELD
    armor:
    - type: IRON_CHESTPLATE
      meta:
        enchants:
          PROTECTION_ENVIRONMENTAL: 3
```

### Custom names

Add a *display-name* key with the name you want, it works with every item.

```yaml
    - type: COOKED_PORKCHOP
      amount: 8
      meta:
        display-name: Delicious bacon
``` 

### Potion effects

You can use potion effects on these four items :
* POTION
* SPLASH_POTION
* LINGERING_POTION
* TIPPED_ARROW

You can set a potion type like in the following example :

```yaml
    - type: TIPPED_ARROW
      amount: 5
      meta:
        potion-type: minecraft:slowness
    - type: SPLASH_POTION
      meta:
        potion-type: minecraft:healing
    - type: LINGERING_POTION
      amount: 2
      meta:
        potion-type: minecraft:strong_speed
    - type: POTION
      meta:
        potion-type: minecraft:long_invisibilty
``` 

You can get potion effects on this page : [Minecraft effect list](https://www.digminecraft.com/lists/effect_list_pc.php)

Be careful to prefix the effect with "minecraft:". You can give level 2 potions (like heath II) 
prefixing the effect with **strong_** or long duration potions with the **long_**
