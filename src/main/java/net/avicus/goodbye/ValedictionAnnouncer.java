package net.avicus.goodbye;

import com.google.common.collect.Sets;
import com.sk89q.minecraft.util.commands.ChatColor;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

public class ValedictionAnnouncer implements Listener {

  private static final Random RANDOM = new Random();
  private final Set<UUID> seen = Sets.newHashSet();
  private String[] motdLines = new String[]{"        Avicus has closed permanently",
      "                Thank You",
      "     Thanks for all the memories!", "         Press F to pay respects"};

  // From the legendary "Avicus Quotes" thread
  private String[] slogans = new String[]{
      "The block lag will be fixed in the next update.", "Tiler wakes up.",
      "You have completed your interview and you have been accepted by the senior staff and will be promoted to Junior Moderator.",
      "Your application has been accepted for an interview.",
      "Your application has been reviewed and is good by the Senior Staff’s standards.",
      "You may NOT submit another application.",
      "I am sorry to say your application has been DENIED.", "Please use /report!",
      "TS Dev is a good idea, right?", "Now supporting 1.7 PVP!", "We've dropped support for 1.7",
      "The Atlas update is coming!", "Credits just became more useful!", "MVP is now in BETA",
      "The senior staff will be hosting weekly megascrims!",
      "Avicus: Building and destroying relationships since 2011!",
      "Hey Sunrise you there? So yeah you basically got mod.", "Avicore is coming in 17 years",
      "kycrafft", "I'm not annoying I'm Mench",
      "Snow, I'm going to have to officially warn you. You have disrespected our supreme lord, Posighdun.",
      "\"Where are these memes created or forged\" - funkystudios",
      "Wait, how long is a permanent ban?", "ProfessorUtonium has destroyed cave.",
      "\"September is an amazing year\" -Zeus", "Yikes.", "I'm single pringled and ready to mingle",
      "See you in game!", "Sho in staff chat: \"HEY LOOK AT ME MOM IM A MINECWAFT POWICEMAN\"",
      "\"Pie has facial hair I like\" - Greg", "\"Go home gamer girl\" -Smit",
      "Greg: \"Tonight's the night that we should probably end it all\"",
      "<18:38:13> \"[Zeusy] Zeusy\" pokes you: Can i touch your Avicore?",
      "<18:33:24> \"[Sli] Fouled\" pokes you: You must be a pressure plate, because you turn me on.",
      "<02:13:42> \"Flo [resepignev]\" pokes you: you make my sticky piston extend",
      "<18:41:43> You poked \"[Zeus] Zeusy\" with message: my viper is venemous",
      "Poland, i thought that was a city. - Maddy", "\"Kylo you suck\" -Austin 2k16",
      "\"My mic is literally in my mouth right now.\" -Steven5703",
      "\"I'm a better woman than you are.\" -ALM/Compendium", "\"THIS BLOCK IS HACKING\"",
      "Harvey: \"Everyone's makeup in my school looks like shrek's eyeliner\"",
      "\"Howsie is activer than you\" - Eric", "Spookz: *beats head on desk*",
      "\"Greg and Cole are dating -Lindstagram",
      "\"You used to poke me on my TeamSpeak, late night when you need my memes. -ALMondCode",
      "\"I had a baby with an avocado\"--Cyanide",
      "\"We shouldn't demote him, I like his skin\" - Iron2k16",
      "\"I told my teacher my dog ate my homework, I told Tazz my dog ate my laptop while screensharing\"~Blaze2k16",
      "\"Stockholm, that's somewhere in England, right?\" - Raging",
      "\"You dirty, dirty cheater! I won because of you!\" -Solstice",
      "\"You're putting the orange wool in the yellow slot\" -kycrafft",
      "\"To tired to sleep, any advice?\" - Apollo", "\"I am two gender\" - ImNotYourTiger",
      "\"The quality of our moderators has dropped significantly\" - Midnight",
      "\"YOU SALAD SAUCE, OMG THAT WAS OFF THE BEANS ON TOASSTT\" -Nemo",
      "\"Elsa, do you have a nice butt?\" -FrostedCupcakez",
      "'If I make an appeal, what am I meant to put? I was not using anti kb, with love and hugs, flowers in the post soon, from Raging <3. That's as fishy as fishy fish come.' -Raging.",
      "\"I can hear that autoclicker in the background??\" -sli",
      "\"BARNEY GET OFF MY KEYBOARD\" -raging", "\"that's r e l y  h o t\" -Eric",
      "\"Don't be kinky. Not now. Don't be kinky\" - Jess",
      "\"How do I post a photo? I wanna show people how hot I really am.\" - Mary",
      "\"im gonna make my secret hard to fine\" -TeamCarry",
      "\"Nah I’m just an ugly half chinese loner that sits and plays minecraft 24/7\" - Evan / Biixerv",
      "\"the avicus fire department is gonna be pissed when they see this\" - Para",
      "Eako: \"Peachy and Mango retired to become juice flavours.\"",
      "\"I stole someone elses skin and put my logo on it.\" -Tynvale",
      "\"Please don't flood the cat\" - ImRaging 2015",
      "*humping monkey Skype emoji* - everyone in Monkey Mafia Skype chat",
      "\"Hey, I found Chatbot in the maze!\" - Petlas",
      "\"i always thought the connection bars told you how close the players are in game\" -MidnightStorm",
      "\"rile i can destroy you in verbal pvp\" -jozz", "\"How do you even spell my name?\" -Rilo",
      "\"Steven, Stop jitter clicking on your soup!\" - Eric", "Seth: \"I am a mapdev.\"",
      "'Brighton, famous for pebbles and gay people ;)' -Pizza", "\"Chicken Nugged\" - ParaSpider",
      "\"Callie, how many children do you have?\" - Zeus", "\"Is an armadillo an animal?\" -Remy",
      "\"Dilpickel can you rollback the server, I was checking instagram\"",
      "\"This is gonna be bad for my stomach, and even worse for the bathroom\" - greg",
      "\"Be ice\" -dil", "\"I kind of just forgot Tasmania existed.\" - Tynvale",
      "[2015-08-25, 3:12:19 PM] Case (Ques): jesss r u gril gamer??1?1?!1?1?2!2??!1?2?",
      "\"Wait, I didn't realise, March is before May\" -Pizza",
      "Eric: \"GO BUY A NEW BRAIN ON EBAY BECAUSE I WANT YOU TO CARE!\"",
      "\"CTH = AutoClicker Simulator\" -kycrafft", "\"AND IM NOT EVEN A RAPER\" -Sevoh",
      "\"Have a good slep\" -AlarmClock", "\"REMOVE IT AND DIE\" -GalaxyBrit",
      "\"Oh no, Spookeh rushing with no armour again! Defend!\" - Zeus2k14",
      "\"My dad said if I ever do that, he would be waiting outside with a shotgun when I got home. Its very southern.\" -Refuse",
      "\"is sweden in canada?\" - MaddyLomer", "Greg: \"SHUT THAT WHITE BITCH UP!\"",
      "'You come to Avicus TS to get trolled, you get trolled right back' -Merlin",
      "\"Normal people take their dogs out for a walk. Australians take their Kangaroos out for a hop\" -SnowSX3",
      "\"Do Australians drink kangaroo milk?\" - Zeusy",
      "\"WHAT!?! BRITNEY IS FILIPINO?\" -Cyanide",
      "\"roses are pvp, voilets are not pvp, I dont like pvper, are we pvping or are we dancer\" - ParaSpider",
      "\"URGH I HATE YOU, I HOPE YOU STEP ON A LEGO\" -GrapeSmoothie",
      "\"You need to be that active but you don't need to be that active\" -Iron",
      "\"Yellow car\" -resepignev", "\"SHUT UP BLIZZEM!!!!\" -Iron",
      "\"I love bias jokes because they're so true.\" - Aerosmith", "\"Rub my kneecaps\" -Upsoar",
      "\"yes steven, in that hole\" -refuse", "\"VenomousViper is a mouse!\" -TheMasterClock",
      "Para: \"DEE DEE! WHAT ARE YOU DOING IN MY LAB! CAN'T YOU SEE I'M WORKING ON YML! YOU FUCKED THE REGIONS UP! DEE DEE\"",
      "\"Hey look I can drive a refrigerator\" ... \"NO! THE REFRIGERATOR! We had so much in common!\" - Para",
      "\"i always say hi because my mommy says it's polite to do so\" -timaeustestified",
      "'MOOOOOOOOM, CAN I HAVE A BANANA?!?!?'- Steven",
      "\"I have a poster in my room that says everyone on Berzerk is flat but me\" - Dankye_",
      "\"I just Breezlyed two blocks, I'm a God\" - Eric",
      "\"Hearing that booger scream in agony is not allowed\" - Sircyanide",
      "\"Snow balls = no balls\" ~ RefuseToSink",
      "\"Annamarie go take a damn shower\" -FrostedCupcakez",
      "\"Like, whenever I enter a game, everyone's like, \"OMG HAI REFOOSE!\" -RefuseToSink",
      "\"bruh ur like 12\" - KarlKorv",
      "\"I need some weesources to give to Michael Jackshon.\"- FrozenSolstice",
      "\"How many hours are in 120 hours\" ~ Iron",
      "Iron: I just banned myself and i had to give an appeal. Porky Denied it",
      "\"We're the Tunnel Snakes, that's us\" -Newcleus",
      "\"Please steven, don't quote it, I'm begging you!\" - Sircyanide",
      "[12:29:29 PM] Hacktivism: Now Ivycode could probably 8-block me",
      "\"I watched 5 hours of motivational lizard and passed my finals. Coincidence? I think not.\" - Steven",
      "\"No Copyright for Nyan Cat!! Respect.\" - RefuseToSink",
      "\"You shouldn't circle strafe someone, without their permission\" -Pizza",
      "my dentist told me tell the tooth and nothing but the tooth - awesome_apricot",
      "\"Ooga Booga go back to meepcraft\" - kycrafft",
      "\"I got punched by a Kangaroo once.\" - Sesspee",
      "[5:54:31 PM] steven5703 ツ (avicus mapdev): APPARENTLY //FLIP SOUTH MEANS FLIP UPSIDE DOWN",
      "\"Life is a journey\" - AtlasRaven (TheOpAsian)",
      "\"oh the staff team r good they host tournament!!!\" - DaGoldBrick",
      "\"Ouch My Armpit\"- Refuse", "\"i'm calling this the\"para is flat shack\"\" ~Darkye_",
      "\"wtf, when I synced changes on github my printer went off\" - steven",
      "\"razzledazzled\" -RazzleDazzled",
      "\"Demote him, actually, send him to a help room, he needs Jesus\"- Tanpopo",
      "Mapdev- \"I'm a creep... love me.\"", "*Really annoying air horn noise* - Steven5703",
      "\"Welcome to the Avicus Podcast\"", "Can't wait to get bowspermed off my bridge - grosssner",
      "\"im like a rubix cube. the more you play with me the harder i get\" - Pokey on Refuse",
      "MLGPorky: wanna hear something funny ... MidnightBeats: your future",
      "\"Wait, Petlas is a girl?\" - 30% of Avicus.",
      "'Grow some balls, and give them to Steven' - SirCyanide",
      "\"Ooo, Ambi's singing, guess who's gone.\" - Sesspee", "\"What the Lmao\" -MLGtino",
      "\" Heat I think you're the only one who doesn't check girls out on facebook \" -JK",
      "Britney: \"Let's just say my face was covered in dried baking soda and water\"",
      "Doctapop/Tyler \"I guess you could say Rile is Riled up xD!!!!!!\"", "\"same\" - TNTPotato",
      "\"Annnnnd Steven goes crazy\" -Shiro", "Sesspee: I will use /report if you use /ban xD",
      "\"That's the power of North Korea\" -Tanpiku", "\"Toldeo\" - Kylo",
      "\"Gary picked me up with his powerful penguin claws\" - ImRaging",
      "\"1v1 me on badlion\" -Legoche", "\"I feel like Shakira\" - Peacheh",
      "\"99 stop getting kills with my name\" - Peacheh", "Sli: \"PLS I almost spit my milk out\"",
      "yo looks ain' gon' getchu pay-eeeeed.cuz you're not that cute. and your hair's uneven. ya look dusteh. and ya stank too. -Ashawana",
      "Clock: \"Shush slack it\"", "\"Jr. Mod has more power, Sr. Mod is trial\" -Para",
      "\"Mapdev is like owner\" -Para",
      "\"The only way you can win Venemous TDM is if you kill kycrafft\" -VenomousViper",
      "\"Whats a California\" - TheMasterClock",
      "*In super high voice with voice changer* \"RAWR\" -Cal",
      "\"Gary is love, Gary is lyfe\" -ImRaging",
      "FrostedCupcakez: 5..4..3,2,1 WE'RE GOING ON A TRIP ON OUR FAVOURITE ROCKET SHIP ZOOMING THROUGH THE SKY. LITTLE EINSTEINS",
      "\"I think I'm high on chocolate.\" - FrozenSolstice", "I CAME IN LIKE A TANK!!! - rilomilo9",
      "\"You see this? This right here. It's a dot, a wonder of nature [insert blown up picture of a dot] Astonishing, wonderful, amazing.\"- FrozenSolstice",
      "\"Daddy dagger!\" - Jess", "\"SeeUSoon\" - l1z",
      "\"sli is being mean 2 me, pls fix him or something :((\" -Astronis", "[5:50 PM] steven: Join play.zildith.net"};

  // All current staff and users w/ retired
  private String[] names = new String[]{"Keenan", "Austin", "funkystudios", "KyloCode", "ALM",
      "smitdalt", "TylerdotMichael", "JDKL", "Passively", "Crazy_", "GrapeSmoothie", "Kojak",
      "Lokigh", "Squidvicus", "alexanderjoe", "PieZ", "oofgg", "falz", "JeTePardonne",
      "ViceWatercolour", "Diabolicx", "L_ve", "SnowSX3", "poofywoo", "LFT", "Junr", "Paulna",
      "FrostedCupcakez", "AstroPizza", "joelous", "Proddyy", "InputIGNHere", "Fouled",
      "_DISTRACTION_", "ProfessorUtonium", "Thepawer", "XUPH", "zicuri", "profbananaslug",
      "Spoookeh", "dev_revs", "nintendoboy11", "EDJM9", "Nintendo_Unity", "Czco", "Vapoureon",
      "SR_Vlado", "Acceqted", "MtnL", "Vior_", "MeMyselfAndGhost", "Myv", "K_R_Cord", "cellish",
      "Stuarts", "G_SKIPPY",
      "BlacktimusPrime", "Bumblebeetle13", "my0445316", "TortouseMincer", "ParaPenguin",
      "FightToWin7431", "Hughsie1", "Hunting_chick", "BenDooley7", "1Theodore1", "Howsie",
      "The_Detonator_", "D00ZiE", "NolanDalton", "cinammoncroc000", "FlufflesSub", "itaity", "_Avy",
      "RCMP_Mountie", "Jake41901", "Princezz_Dubstep", "Solux", "tel6331", "Shirokamii",
      "MerlinMaster", "_Stormz", "Porkyyy", "RefuseToSink", "Polar_Express", "DoctaPop",
      "GalaxyBrit", "Pavlo", "Emmaye", "Mango_", "DJ_Barnsey", "izjust4fun", "FrozenThorn", "_Gill",
      "Legoche", "Tynvale", "HarryRules2002", "Colecrc", "MidnightBeats", "Ogrey", "SirCyaniide",
      "itsnotbrit", "ImRaging", "Hete", "PublixEmployee", "MasterProX", "UnkelBen", "Stimulating",
      "_Nathy", "Iron", "Sho", "Pelpelajax", "faht", "Tazz", "Newcleus", "SrJunioor_", "tomqss",
      "Myworld6", "hasl", "AMIES", "Spartemex", "TheMasterClock", "Clijmart", "killerbye22",
      "imryaan", "Posighdun", "Ciaan", "resepignev", "XGalibur", "BoldAndBrash", "xNemoII",
      "XtraTestic4l", "IzikW", "Kashike", "Zeusy", "Sp4rrkii", "PokerFace", "EncryptedShoesHD",
      "dicip", "Riilo", "Cyclops", "rinn", "Vobaseball12"};

  @EventHandler
  public void onPing(ProxyPingEvent event) {
    StringBuilder motd = new StringBuilder();
    motd.append("          &f❖ &bAvicus Network&r &c2011-2018 &f❖");
    motd.append("\n");
    motd.append("&4&l" + motdLines[RANDOM.nextInt(motdLines.length)]);
    event.getResponse().setDescription(ChatColor.translateAlternateColorCodes('&', motd.toString()));
  }

  @EventHandler(priority = EventPriority.LOWEST)
  public void onConnect(ServerConnectEvent event) {
    boolean firstTime = !seen.contains(event.getPlayer().getUniqueId());
    // If the've seen the message once, we can show them some funny things
    if (firstTime) {
      seen.add(event.getPlayer().getUniqueId());
    }
    StringBuilder sad = new StringBuilder();
    sad.append(ChatColor.GOLD + event.getPlayer().getName() + ChatColor.AQUA + ", ");
    sad.append("\n");
    sad.append(ChatColor.AQUA
        + "If you don't already know, Avicus has closed and will no longer be accepting connections.");
    sad.append("\n");
    sad.append(ChatColor.AQUA
        + "We would like to thank you all for all of the time we have shared and memories we have made.");
    sad.append("\n");
    if (firstTime) {
      sad.append(ChatColor.AQUA
          + "I guess the slogan was right; Games we loved and a community we loved even more.");
      sad.append("\n");
      sad.append(
          ChatColor.BLUE + "Thanks for everything, " + ChatColor.GOLD + "Keenan" + ChatColor.BLUE
              + " and " + ChatColor.GOLD + "Austin" + ChatColor.BLUE + ". " + ChatColor.RED + "<3");
      sad.append("\n");
      sad.append(ChatColor.BOLD.toString() + ChatColor.AQUA + "NOTE: " + ChatColor.GOLD
          + "We are showing you the original message since this is the first time you're reading this.");
      sad.append("\n");
      sad.append(
          "All subsequent reconnects will display a unique quote (" + (slogans.length + 1) + " possibilities!) and pay honor to current and former staff.");
    } else {
      String name1 = names[RANDOM.nextInt(names.length)];
      String name2 = names[RANDOM.nextInt(names.length)];
      String slogan = slogans[RANDOM.nextInt(slogans.length)];
      sad.append(ChatColor.BLUE + "Random Quote: " + ChatColor.GREEN + ChatColor.ITALIC + slogan);
      sad.append("\n");
      sad.append(
          ChatColor.BLUE + "Thanks " + ChatColor.GOLD + name1 + ChatColor.BLUE
              + " and " + ChatColor.GOLD + name2 + ChatColor.BLUE
              + " for all the work you did for the server! " + ChatColor.RED + "<3");
    }
    event.getPlayer().disconnect(sad.toString());
  }
}
