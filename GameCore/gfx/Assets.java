//This is the assets class. It loads all of the png images required for the game before it begins, and assigns them to arrays and variables.
// this way the images are all loaded at once, during launch. 

package GameCore.gfx;

import java.awt.image.*;
import javax.sound.sampled.AudioInputStream;


public class Assets {
  
  public static BufferedImage plain1, plain2, lake, rock, cloud1, cloud2, cloud3, sky1, bridge1, bridge2, bridge3, bridge4, water, cliff1, cliff2, grass, path, hud1, titlescreen, introscreen, endscreen, endscreen2, pickscreen, pickscreen2, pickscreen01, pickscreen02, stagescreen, silenced;
  
  public static BufferedImage [] btn_start, btn_intro, heals, charCards, hCrystal, angelUp, angelDown, angelLeft, angelRight; //image arrays
  
  public static BufferedImage tree;
  
  public static BufferedImage [] sephN, sephN2, sephMR, sephML, sephMD, sephMU, sephLA, sephLA2, sephHA, sephHA2, sephBI, sephBI2, sephBF, sephBF2, 
    sephDT, sephDT2, sephDA, sephDA2, sephDag, sephDag2, sephSong, sephSong2, sephUlt, sephUlt2, sephAbils, sephF, sephF2, sephS, sephS2, sephBS, sephBS2;
  
  public static BufferedImage[] grayN, grayN2, grayMR, grayML, grayMD, grayMU, grayLA, grayLA2, grayHA, grayHA2, graySS, graySS2, graySC, graySC2, grayRS, grayRS2, grayUC, grayUC2, grayF, grayF2, grayS, grayS2, arunLia, grayAbils;
  
  public static BufferedImage[] luxN, luxN2, luxMR, luxML, luxMD, luxMU, luxLA, luxLA2, luxHA, luxHA2, luxSV, luxSV2, luxV, luxV2, luxRS, luxRS2, luxUC, luxUC2, luxVD, luxAR, luxAR2, luxF, luxF2, luxS, luxS2, luxAbils;
  
  public static BufferedImage[] altN, altN2, altMR, altML, altMD, altMU, altLA, altLA2, altHA, altHA2, altBI, altBI2, altBF, altBF2, altBB, altBB2, altLT, altLT2, altLC, altLC2, altLL, altLL2, altI, altMark, altFW, altFW2, altUC, altUC2, altS, altS2, altF, altF2, altAbils, tSurge, altW, altWave, altWave2, altChain;
  
  public static BufferedImage[] ironN, ironN2, ironMR, ironML, ironMD, ironMU, ironLA, ironLA2, ironHA, ironHA2, ironF, ironF2, ironS, ironS2, ironSG1, ironSG2, ironI, ironRC, ironWR, ironWR2, ironRC2, sprintUp, sprintDown, sprintLeft, sprintRight, beat, ironAbils;

  public static BufferedImage[] taN, taN2, taMR, taML, taMD, taMU, taLA, taLA2, taHA, taHA2, taF, taF2, taS, taS2, taFB, taFB2, taFBH, taFBH2, taSP, taSP2, taSPP, taSPP2, taSB, taCC, taCC2, taFC, taUC, taUC2, tof, taFN, taFN2, taFLA, taFLA2, taFL, taFL2, taFG, taFG2, taMFB, taMFB2, taPW, taAbils;
  
  public static BufferedImage[] laN, laN2, laMR, laML, laMD, laMU, laLA, laLA2, laHA, laHA2, laST, laST2, laSH, laSH2, laS, laS2, laF, laF2, shade1, shade2, laC, laC2, laUC, laUC2, laFN, laFN2, laDD, laDD2, laFR, laFR2, laAbils; 

  public static BufferedImage[] alN, alN2, alMR, alML, alMU, alMD, alLA, alLA2, alHA, alHA2, bullet, alT, alT2, aFlask, aBreak, alS, alS2, alF, alF2, acid, acidFire, alSR, alSR2, alMP, alMP2, mineIdle, mineTrig, alAbils;
  
  public static AudioInputStream titleTheme;
  
  public static void init () {
    
    SpriteSheet tileSheet = new SpriteSheet ("/textures/All Tiles.png");
    SpriteSheet tileSheet2 = new SpriteSheet ("/textures/Cloud Tiles.png");
    SpriteSheet tileSheet3 = new SpriteSheet ("/textures/bon.png");
    SpriteSheet tileSheet4 = new SpriteSheet ("/textures/background2.png");
    SpriteSheet texs = new SpriteSheet ("/textures/tex.png");
    SpriteSheet healing = new SpriteSheet ("/textures/healing.png");
    SpriteSheet chars = new SpriteSheet ("/textures/charcards.png");
    SpriteSheet hcrystal = new SpriteSheet ("/textures/Crystal.png");  
    SpriteSheet angelSheet = new SpriteSheet("/ents/angel.png");
    
    hud1 = ImageLoader.loadImage("/textures/hud.png");
    titlescreen = ImageLoader.loadImage("/textures/titlescreen.png");
    introscreen = ImageLoader.loadImage("/textures/introscreen.png");
    pickscreen = ImageLoader.loadImage("/textures/picking.png");
    pickscreen2 = ImageLoader.loadImage("/textures/picking2.png");
    pickscreen01 = ImageLoader.loadImage("/textures/picking1.5.png");
    pickscreen02 = ImageLoader.loadImage("/textures/picking2.5.png");    
    stagescreen = ImageLoader.loadImage("/textures/stagepick.png");
    endscreen = ImageLoader.loadImage("/textures/go1.png");
    endscreen2 = ImageLoader.loadImage("/textures/go2.png");
    tree = ImageLoader.loadImage("/textures/tree.png");
    silenced = ImageLoader.loadImage("/textures/silence.png");
    
    // sephira stuff
    SpriteSheet sephi1 = new SpriteSheet ("/seph/Sephira Sheet1.png");
    SpriteSheet sephiLA = new SpriteSheet  ("/seph/Sephira Light Attack Left.png");
    SpriteSheet sephiLA2 = new SpriteSheet  ("/seph/Sephira Light Attack Right.png");
    SpriteSheet sephiHA = new SpriteSheet  ("/seph/Sephira Heavy Attack Left.png");
    SpriteSheet sephiHA2 = new SpriteSheet  ("/seph/Sephira Heavy Attack Right.png");
    SpriteSheet sephiBI = new SpriteSheet  ("/seph/Sephira Blink Init Left.png");
    SpriteSheet sephiBI2 = new SpriteSheet  ("/seph/Sephira Blink Init Right.png");
    SpriteSheet sephiBF = new SpriteSheet  ("/seph/Sephira Blink Final Left.png");
    SpriteSheet sephiBF2 = new SpriteSheet  ("/seph/Sephira Blink Final Right.png");
    SpriteSheet sephiDT = new SpriteSheet ("/seph/Sephira Dagger Throw Left.png");
    SpriteSheet sephiDT2 = new SpriteSheet ("/seph/Sephira Dagger Throw Right.png");
    SpriteSheet sephiDA = new SpriteSheet ("/seph/Dagger Attack Left.png");
    SpriteSheet sephiDA2 = new SpriteSheet ("/seph/Dagger Attack Right.png");
    SpriteSheet sephiDag = new SpriteSheet ("/seph/TD Projectile Left.png");
    SpriteSheet sephiDag2 = new SpriteSheet ("/seph/TD Projectile Right.png");
    SpriteSheet sephiSong = new SpriteSheet ("/seph/Sephira Ulti Cast Left.png");
    SpriteSheet sephiSong2 = new SpriteSheet ("/seph/Sephira Ulti Cast Right.png");
    SpriteSheet sephiUlt = new SpriteSheet ("/seph/Sephira Song of Roharen Left.png");
    SpriteSheet sephiUlt2 = new SpriteSheet ("/seph/Sephira Song of Roharen Right.png");
    SpriteSheet sephiAbils = new SpriteSheet ("/textures/sephira abilities.png");  
    SpriteSheet sephiBS = new SpriteSheet ("/seph/Sephira Blink Strike Left.png");
    SpriteSheet sephiBS2 = new SpriteSheet ("/seph/Sephira Blink Strike Right.png");
    
    //grayson stuff
  SpriteSheet grays1 = new SpriteSheet ("/gray/Grayson Sheet1.png");
  SpriteSheet graysLA = new SpriteSheet  ("/gray/Grayson Light Attack Left.png");
  SpriteSheet graysLA2 = new SpriteSheet  ("/gray/Grayson Light Attack Right.png");
  SpriteSheet graysHA = new SpriteSheet  ("/gray/Grayson Heavy Attack Left.png");
  SpriteSheet graysHA2 = new SpriteSheet  ("/gray/Grayson Heavy Attack Right.png");
  SpriteSheet graysSS = new SpriteSheet  ("/gray/Grayson Shield Left.png");
  SpriteSheet graysSS2 = new SpriteSheet  ("/gray/Grayson Shield Right.png");
  SpriteSheet graysRS = new SpriteSheet  ("/gray/Grayson Runeshard Left.png");
  SpriteSheet graysRS2 = new SpriteSheet  ("/gray/Grayson Runeshard Right.png");
  SpriteSheet graysSC = new SpriteSheet ("/gray/Grayson Shield Charge Left.png");
  SpriteSheet graysSC2 = new SpriteSheet ("/gray/Grayson Shield Charge Right.png");
  SpriteSheet graysUC = new SpriteSheet ("/gray/Grayson Ulti Cast Left.png");
  SpriteSheet graysUC2 = new SpriteSheet ("/gray/Grayson Ulti Cast Right.png");
  SpriteSheet arunlia = new SpriteSheet ("/gray/Arun-Lia Effect.png");  
  SpriteSheet graysAbils = new SpriteSheet ("/textures/Grayson Abilities.png");
  
  //luxaar stuff
  SpriteSheet lux1 = new SpriteSheet ("/lux/Luxaar Sheet1.png");  
  SpriteSheet luxaLA = new SpriteSheet("/lux/Luxaar Light Attack Left.png");   
  SpriteSheet luxaLA2 = new SpriteSheet("/lux/Luxaar Light Attack Right.png");   
  SpriteSheet luxaHA = new SpriteSheet("/lux/Luxaar Heavy Attack Left.png");
  SpriteSheet luxaHA2 = new SpriteSheet("/lux/Luxaar Heavy Attack Right.png");  
  SpriteSheet luxaSV = new SpriteSheet("/lux/Luxaar Volley Cast Left.png");   
  SpriteSheet luxaSV2 = new SpriteSheet("/lux/Luxaar Volley Cast Right.png");
  SpriteSheet luxaV = new SpriteSheet("/lux/volley left.png");   
  SpriteSheet luxaV2 = new SpriteSheet("/lux/volley right.png"); 
  SpriteSheet luxaRS = new SpriteSheet("/lux/Luxaar Ret Stand Left.png");
  SpriteSheet luxaRS2 = new SpriteSheet("/lux/Luxaar Ret Stand Right.png"); 
  SpriteSheet luxaUC = new SpriteSheet("/lux/Luxaar Ulti Cast left.png"); 
  SpriteSheet luxaUC2 = new SpriteSheet("/lux/Luxaar Ulti Cast Right.png");   
  SpriteSheet luxaVD = new SpriteSheet("/lux/valliant detonation.png"); 
  SpriteSheet luxaAR = new SpriteSheet("/lux/Luxaar Projectile Left.png"); 
  SpriteSheet luxaAR2 = new SpriteSheet("/lux/Luxaar Projectile Right.png"); 
  SpriteSheet luxaAbils = new SpriteSheet("/textures/Luxaar Abilities.png"); 
  
  //alta stuff 
  SpriteSheet alta1 = new SpriteSheet ("/alta/Alta Sheet1.png");
  SpriteSheet alta2 = new SpriteSheet ("/alta/Alta Sheet2.png");
  SpriteSheet altaLA = new SpriteSheet("/alta/Alta Light Attack Left.png");   
  SpriteSheet altaLA2 = new SpriteSheet("/alta/Alta Light Attack  Right.png");   
  SpriteSheet altaHA = new SpriteSheet("/alta/Alta Heavy Attack Left.png");
  SpriteSheet altaHA2 = new SpriteSheet("/alta/Alta Heavy Attack Right.png");   
  SpriteSheet altaBB = new SpriteSheet ("/alta/Boltback Effect Left.png");
  SpriteSheet altaBB2 = new SpriteSheet ("/alta/Boltback Effect Right.png");
  SpriteSheet altaFW = new SpriteSheet ("/alta/Alta Flash Wave Cast Left.png");
  SpriteSheet altaFW2 = new SpriteSheet ("/alta/Alta Flash Wave Cast Right.png"); 
  SpriteSheet altaUC = new SpriteSheet ("/alta/Alta Ulti Cast Left.png");
  SpriteSheet altaUC2 = new SpriteSheet ("/alta/Alta Ulti Cast Right.png");
  SpriteSheet altaAbils = new SpriteSheet("/textures/Alta Abilities.png"); 
  SpriteSheet thundSurge = new SpriteSheet("/alta/Ulti Effect.png"); 
  SpriteSheet altaChain = new SpriteSheet("/alta/chain.png");
  SpriteSheet altaWave = new SpriteSheet("/alta/Flash Wave Left.png");
  SpriteSheet altaWave2 = new SpriteSheet("/alta/Flash Wave Right.png");
  SpriteSheet altaThrow = new SpriteSheet("/alta/Alta Light Strike Init Left.png");
  SpriteSheet altaThrow2 = new SpriteSheet("/alta/Alta Light Strike Init Right.png");
  SpriteSheet altaLand = new SpriteSheet("/alta/Light Strike Land Left.png");
  SpriteSheet altaLand2 = new SpriteSheet("/alta/Light Strike Right.png");
  
  //iron fiend stuff
  SpriteSheet iron1 = new SpriteSheet ("/ironfiend/Iron Fiend Sheet1.png");  
  SpriteSheet ironfLA = new SpriteSheet("/ironfiend/Iron Fiend Light Attack Left.png");   
  SpriteSheet ironfLA2 = new SpriteSheet("/ironfiend/Iron Fiend Light Attack Right.png");   
  SpriteSheet ironfHA = new SpriteSheet("/ironfiend/Iron Fiend Heavy Attack Left.png");
  SpriteSheet ironfHA2 = new SpriteSheet("/ironfiend/Iron Fiend Heavy Attack Right.png");     
  SpriteSheet ironfSG = new SpriteSheet("/ironfiend/SG Effect.png");
  SpriteSheet ironfSG2 = new SpriteSheet("/ironfiend/SG Effect 2.png");
  SpriteSheet ironfRC = new SpriteSheet("/ironfiend/Iron Fiend Ring Cast Right.png");
  SpriteSheet ironfRC2 = new SpriteSheet("/ironfiend/Iron Fiend Ring Cast Left.png");  
  SpriteSheet ironfI = new SpriteSheet("/ironfiend/blaze.png");
  SpriteSheet sprints = new SpriteSheet("/ironfiend/sprint effect.png");
  SpriteSheet beatf = new SpriteSheet("/ironfiend/beat.png");
  SpriteSheet ironfWR = new SpriteSheet("/ironfiend/Iron Fiend Wild Rend Left.png");
  SpriteSheet ironfWR2 = new SpriteSheet("/ironfiend/Iron Fiend Wild Rend Right.png");
  SpriteSheet ironfAbils = new SpriteSheet("/textures/Iron Fiend Abilities.png");
  
    //ta fi rah stuff
  SpriteSheet ta1 = new SpriteSheet ("/tafirah/Ta-Fi-Rah Sheet1.png");
  SpriteSheet ta2 = new SpriteSheet ("/tafirah/Ta-Fi-Rah Sheet2.png"); 
  SpriteSheet ta3 = new SpriteSheet ("/tafirah/Ta-Fi-Rah Sheet3.png");
  SpriteSheet ta4 = new SpriteSheet ("/tafirah/TaFiRah Sheet4.png");
  SpriteSheet tafPW = new SpriteSheet ("/tafirah/Wings.png");
  SpriteSheet tafFB = new SpriteSheet("/tafirah/Fireball Left.png");
  SpriteSheet tafFB2 = new SpriteSheet("/tafirah/Fireball Right.png");   
  SpriteSheet tafFBH = new SpriteSheet("/tafirah/Fireball Heavy Left.png");
  SpriteSheet tafFBH2 = new SpriteSheet("/tafirah/Fireball Heavy Right.png");   
  SpriteSheet tafMFB = new SpriteSheet("/tafirah/MegaFireRight.png"); 
  SpriteSheet tafMFB2 = new SpriteSheet("/tafirah/MegaFire Left.png");    
  SpriteSheet tafSP = new SpriteSheet("/tafirah/Ta-Fi-Rah Spear of Flame Left.png");
  SpriteSheet tafSP2 = new SpriteSheet("/tafirah/Ta-Fi-Rah Spear of Flame Right.png");
  SpriteSheet tafSPP = new SpriteSheet("/tafirah/Flame Spear Right.png");
  SpriteSheet tafSPP2 = new SpriteSheet("/tafirah/Flame Spear Left.png");
  SpriteSheet tafSB = new SpriteSheet("/tafirah/Spear Bomb.png");
  SpriteSheet tafCC = new SpriteSheet("/tafirah/Ta-Fi-Rah Cone Cast Left.png"); 
  SpriteSheet tafCC2 = new SpriteSheet("/tafirah/Ta-Fi-Rah Cone Cast Right.png"); 
  SpriteSheet tafFC = new SpriteSheet("/tafirah/Flame Column.png");
  SpriteSheet taftof = new SpriteSheet("/tafirah/Tof effect.png");
  SpriteSheet tafAbils = new SpriteSheet("/textures/TaFiRah Abilties.png");
  
   //lauda stuff
    SpriteSheet la1 = new SpriteSheet ("/lauda/Lauda Sheet1.png");
 SpriteSheet lafLA = new SpriteSheet("/lauda/Lauda Light Attack Left.png");   
 SpriteSheet lafLA2 = new SpriteSheet("/lauda/Lauda Light Attack Right.png");   
 SpriteSheet lafHA = new SpriteSheet("/lauda/Lauda Heavy Attack Left.png");
 SpriteSheet lafHA2 = new SpriteSheet("/lauda/Lauda Heavy Attack Right.png");   
 SpriteSheet lafST = new SpriteSheet("/lauda/Lauda Spec Left.png");   
 SpriteSheet lafST2 = new SpriteSheet("/lauda/Lauda Spec Right.png");  
 SpriteSheet lafSH = new SpriteSheet("/lauda/Lauda Spec Traj Hit Left.png");  
 SpriteSheet lafSH2 = new SpriteSheet("/lauda/Lauda Spec Traj Hit Right.png");   
 SpriteSheet laShade1 = new SpriteSheet("/lauda/Shade Effect.png");
 SpriteSheet laShade2 = new SpriteSheet("/lauda/shade effect2.png");
 SpriteSheet lafC = new SpriteSheet("/lauda/Lauda Claw and Fang Left.png");
 SpriteSheet lafC2 = new SpriteSheet("/lauda/Lauda Claw and Fang Right.png");   
 SpriteSheet lafUC = new SpriteSheet ("/lauda/Lauda Ulti Cast Left.png"); 
 SpriteSheet lafUC2 = new SpriteSheet ("/lauda/Lauda Ulti Cast Right.png"); 
 SpriteSheet lafDD = new SpriteSheet ("/lauda/Lauda Death Drop Left.png");
 SpriteSheet lafDD2 = new SpriteSheet ("/lauda/Lauda Death Drop Right.png");
 SpriteSheet lafFR = new SpriteSheet ("/lauda/Lauda Flight Full Rend Left.png");
 SpriteSheet lafFR2 = new SpriteSheet ("/lauda/Lauda Flight Full Rend Right.png");
 SpriteSheet lafAbils = new SpriteSheet("/textures/Lauda Abilities.png");
 
 //Sir allistar
 SpriteSheet al1 = new SpriteSheet("/alli/Allistar Sheet1.png");
 SpriteSheet al2 = new SpriteSheet("/alli/Sir Allistar Sheet2.png");
 SpriteSheet alRoll = new SpriteSheet("/alli/Sir Allistar Shoot Roll.png");
 SpriteSheet alRoll2 = new SpriteSheet("/alli/Sir Allistar Shoot Roll2.png");
 SpriteSheet effect1 = new SpriteSheet("/alli/Acid Pool.png");
 SpriteSheet effect2 = new SpriteSheet("/alli/Acid Pool Ignite.png");
 SpriteSheet allAbils = new SpriteSheet("/textures/Allistar Sheet.png");
 
  //tiles
    plain1 = tileSheet.crop(0, 0, 64, 64);
    plain2 = tileSheet.crop(64, 64, 64, 64);
    lake = tileSheet.crop(64, 0, 64, 64);
    rock = tileSheet.crop(0, 64, 64, 64);
    
    cloud1 = tileSheet2.crop(0, 0, 64, 64);
    cloud3 = tileSheet2.crop(64, 64, 64, 64);
    cloud2 = tileSheet2.crop(64, 0, 64, 64);
    sky1 = tileSheet2.crop(0, 64, 64, 64);
    
    bridge1 = tileSheet3.crop(0, 0, 64, 64);
    bridge2 = tileSheet3.crop(64, 64, 64, 64);
    bridge3 = tileSheet3.crop(64, 0, 64, 64);
    water = tileSheet3.crop(0, 64, 64, 64);
    bridge4 = tileSheet3.crop(0, 128, 64, 64);
    
    cliff1 = tileSheet4.crop(0, 0, 64, 64);
    cliff2 = tileSheet4.crop(64, 0, 64, 64);
    grass = tileSheet4.crop(0, 64, 64, 64);
    path = tileSheet4.crop(64, 64, 64, 64);
    
   btn_start = new BufferedImage [2];
   btn_start [0] = texs.crop (0, 0, 256, 128);
   btn_start [1] = texs.crop (256, 0, 256, 128);
   
   charCards = new BufferedImage [8];
   charCards [0] = chars.crop(0, 0, 257, 349); //sephira
   charCards [1] = chars.crop(257, 0, 257, 349); //grayson
   charCards [2] = chars.crop(0, 349, 257, 349); // luxaar
   charCards [3] = chars.crop(257, 349, 257, 349); //alta
   charCards [4] = chars.crop(514, 0, 257, 349); //iron fiend
   charCards [5] = chars.crop(514, 349, 257, 359);//tafirah
   charCards [6] = chars.crop(773, 0, 257, 349); //lauda
   charCards [7] = chars.crop(773, 349, 257, 359); //allistar
         
   btn_intro = new BufferedImage [2];
   btn_intro [0] = texs.crop (0, 128, 256, 128);
   btn_intro [1] = texs.crop (256, 128, 256, 128);   //all image crops
   
   heals = new BufferedImage[4];
   heals[0] = healing.crop(0, 0, 192, 192);
   heals[1] = healing.crop(192, 0, 192, 192);
   heals[2] = healing.crop(0, 192, 192, 192);
   heals[3] = healing.crop(192, 192, 192, 192);
   
   hCrystal = new BufferedImage[3];
   hCrystal[0] = hcrystal.crop(0, 0, 120, 240);
   hCrystal[1] = hcrystal.crop(120, 0, 120, 240);
   hCrystal[2] = hcrystal.crop(0, 240, 120, 240);
   
   angelUp = new BufferedImage[3];
   angelUp[0] = angelSheet.crop(0, 432, 144, 144);
   angelUp[1] = angelSheet.crop(144, 432, 144, 144);
   angelUp[2] = angelSheet.crop(288, 432, 144, 144);
   
   angelDown = new BufferedImage[3];
   angelDown[0] = angelSheet.crop(0, 0, 144, 144);
   angelDown[1] = angelSheet.crop(144, 0, 144, 144);
   angelDown[2] = angelSheet.crop(288, 0, 144, 144);
   
   angelLeft = new BufferedImage[3];
   angelLeft[0] = angelSheet.crop(0, 144, 144, 144);
   angelLeft[1] = angelSheet.crop(144, 144, 144, 144);
   angelLeft[2] = angelSheet.crop(288, 144, 144, 144);
   
   angelRight = new BufferedImage[3];
   angelRight[0] = angelSheet.crop(0, 288, 144, 144);
   angelRight[1] = angelSheet.crop(144, 288, 144, 144);
   angelRight[2] = angelSheet.crop(288, 288, 144, 144);
   
   //sephira 
   
  sephAbils = new BufferedImage[6];
  sephAbils[0] = sephiAbils.crop(0, 0, 64, 64);
  sephAbils[1] = sephiAbils.crop(64, 64, 64, 64);
  sephAbils[4] = sephiAbils.crop(64, 0, 64, 64);
  sephAbils[5] = sephiAbils.crop(0, 128, 64, 64);
  sephAbils[2] = sephiAbils.crop(0, 64, 64, 64);   
  sephAbils[3] = sephiAbils.crop(64, 128, 64, 64);
   
   sephN = new BufferedImage [2];
   sephN [0] = sephi1.crop (0, 0, 192, 192);
   sephN [1] = sephi1.crop (0, 192, 192, 192); 
   
   sephN2 = new BufferedImage [2];
   sephN2 [0] = sephi1.crop (192, 0, 192, 192);
   sephN2 [1] = sephi1.crop (192, 192, 192, 192);
   
  sephML = new BufferedImage [3];
  sephML [0] = sephi1.crop (768, 384, 192, 192);
  sephML [1] = sephi1.crop (960, 384, 192, 192);
  sephML [2] = sephi1.crop (768, 576, 192, 192);
  
  sephMR = new BufferedImage [3];
  sephMR [0] = sephi1.crop (0, 768, 192, 192);
  sephMR [1] = sephi1.crop (192, 768, 192, 192);
  sephMR [2] = sephi1.crop (0, 960, 192, 192);
  
  sephMD = new BufferedImage [3];
  sephMD [0] = sephi1.crop (768, 768, 192, 192);
  sephMD [1] = sephi1.crop (960, 768, 192, 192);
  sephMD [2] = sephi1.crop (768, 960, 192, 192);
  
  sephMU = new BufferedImage [3];
  sephMU [0] = sephi1.crop (384, 768, 192, 192);
  sephMU [1] = sephi1.crop (576, 768, 192, 192);
  sephMU [2] = sephi1.crop (384, 960, 192, 192);
  
  sephLA = new BufferedImage [8];
  sephLA [0] = sephiLA.crop (0, 0, 210, 210);
  sephLA [1] = sephiLA.crop (210, 0, 210, 210);
  sephLA [2] = sephiLA.crop (420, 0, 210, 210);
  sephLA [3] = sephiLA.crop (0, 210, 210, 210);
  sephLA [4] = sephiLA.crop (210, 210, 210, 210);
  sephLA [5] = sephiLA.crop (420, 210, 210, 210);
  sephLA [6] = sephiLA.crop (0, 420, 210, 210);
  sephLA [7] = sephiLA.crop (210, 420, 210, 210);
                                            
  sephLA2 = new BufferedImage [8];
  sephLA2 [0] = sephiLA2.crop (0, 0, 210, 210);
  sephLA2 [1] = sephiLA2.crop (210, 0, 210, 210);
  sephLA2 [2] = sephiLA2.crop (420, 0, 210, 210);
  sephLA2 [3] = sephiLA2.crop (0, 210, 210, 210);
  sephLA2 [4] = sephiLA2.crop (210, 210, 210, 210);
  sephLA2 [5] = sephiLA2.crop (420, 210, 210, 210);
  sephLA2 [6] = sephiLA2.crop (0, 420, 210, 210);
  sephLA2 [7] = sephiLA2.crop (210, 420, 210, 210);
  
  sephHA = new BufferedImage [12];
  sephHA [0] = sephiHA.crop (0, 0, 210, 210);
  sephHA [1] = sephiHA.crop (210, 0, 210, 210);
  sephHA [2] = sephiHA.crop (420, 0, 210, 210);
  sephHA [3] = sephiHA.crop (0, 210, 210, 210);
  sephHA [4] = sephiHA.crop (210, 210, 210, 210);
  sephHA [5] = sephiHA.crop (420, 210, 210, 210);
  sephHA [6] = sephiHA.crop (0, 420, 210, 210);
  sephHA [7] = sephiHA.crop (210, 420, 210, 210);
  sephHA [8] = sephiHA.crop (420, 420, 210, 210);
  sephHA [9] = sephiHA.crop (0, 630, 210, 210);
  sephHA [10] = sephiHA.crop (210, 630, 210, 210);
  sephHA [11] = sephiHA.crop (420, 630, 210, 210);
  
  sephHA2 = new BufferedImage [12];
  sephHA2 [0] = sephiHA2.crop (0, 0, 210, 210);
  sephHA2 [1] = sephiHA2.crop (210, 0, 210, 210);
  sephHA2 [2] = sephiHA2.crop (420, 0, 210, 210);
  sephHA2 [3] = sephiHA2.crop (0, 210, 210, 210);
  sephHA2 [4] = sephiHA2.crop (210, 210, 210, 210);
  sephHA2 [5] = sephiHA2.crop (420, 210, 210, 210);
  sephHA2 [6] = sephiHA2.crop (0, 420, 210, 210);
  sephHA2 [7] = sephiHA2.crop (210, 420, 210, 210);
  sephHA2 [8] = sephiHA2.crop (420, 420, 210, 210);
  sephHA2 [9] = sephiHA2.crop (0, 630, 210, 210);
  sephHA2 [10] = sephiHA2.crop (210, 630, 210, 210);
  sephHA2 [11] = sephiHA2.crop (420, 630, 210, 210);
  
  sephBI = new BufferedImage [5];
  sephBI [0] = sephiBI.crop (0, 0, 300, 210);
  sephBI [1] = sephiBI.crop (300, 0, 300, 210);
  sephBI [2] = sephiBI.crop (0, 210, 300, 210);
  sephBI [3] = sephiBI.crop (300, 210, 300, 210);
  sephBI [4] = sephiBI.crop (0, 420, 300, 210);
  
  sephBI2 = new BufferedImage [5];
  sephBI2 [0] = sephiBI2.crop (0, 0, 300, 210);
  sephBI2 [1] = sephiBI2.crop (300, 0, 300, 210);
  sephBI2 [2] = sephiBI2.crop (0, 210, 300, 210);
  sephBI2 [3] = sephiBI2.crop (300, 210, 300, 210);
  sephBI2 [4] = sephiBI2.crop (0, 420, 300, 210);
  
  sephBS = new BufferedImage [10];
  sephBS [0] = sephiBS.crop(0, 0, 300, 210);
  sephBS [1] = sephiBS.crop(300, 0, 300, 210);
  sephBS [2] = sephiBS.crop(600, 0, 300, 210);
  sephBS [3] = sephiBS.crop(0, 210, 300, 210);
  sephBS [4] = sephiBS.crop(300, 210, 300, 210);
  sephBS [5] = sephiBS.crop(600, 210, 300, 210);
  sephBS [6] = sephiBS.crop(0, 420, 300, 210);
  sephBS [7] = sephiBS.crop(300, 420, 300, 210);
  sephBS [8] = sephiBS.crop(600, 420, 300, 210);
  sephBS [9] = sephiBS.crop(0, 630, 300, 210);
  
  sephBS2 = new BufferedImage [10];
  sephBS2 [0] = sephiBS2.crop(0, 0, 300, 210);
  sephBS2 [1] = sephiBS2.crop(300, 0, 300, 210);
  sephBS2 [2] = sephiBS2.crop(600, 0, 300, 210);
  sephBS2 [3] = sephiBS2.crop(0, 210, 300, 210);
  sephBS2 [4] = sephiBS2.crop(300, 210, 300, 210);
  sephBS2 [5] = sephiBS2.crop(600, 210, 300, 210);
  sephBS2 [6] = sephiBS2.crop(0, 420, 300, 210);
  sephBS2 [7] = sephiBS2.crop(300, 420, 300, 210);
  sephBS2 [8] = sephiBS2.crop(600, 420, 300, 210);
  sephBS2 [9] = sephiBS2.crop(0, 630, 300, 210);
  
  sephBF = new BufferedImage [6];
  sephBF [0] = sephiBF.crop (0, 0, 300, 210);
  sephBF [1] = sephiBF.crop (300, 0, 300, 210);
  sephBF [2] = sephiBF.crop (0, 210, 300, 210);
  sephBF [3] = sephiBF.crop (300, 210, 300, 210);
  sephBF [4] = sephiBF.crop (0, 420, 300, 210);
  sephBF [5] = sephiBF.crop (300, 420, 300, 210);
  
  sephBF2 = new BufferedImage [6];
  sephBF2 [0] = sephiBF2.crop (0, 0, 300, 210);
  sephBF2 [1] = sephiBF2.crop (300, 0, 300, 210);
  sephBF2 [2] = sephiBF2.crop (0, 210, 300, 210);
  sephBF2 [3] = sephiBF2.crop (300, 210, 300, 210);
  sephBF2 [4] = sephiBF2.crop (0, 420, 300, 210);
  sephBF2 [5] = sephiBF2.crop (300, 420, 300, 210);
  
  sephDT = new BufferedImage [4];
  sephDT [0] = sephiDT.crop(0, 0, 270, 270);
  sephDT [1] = sephiDT.crop(270, 0, 270, 270);
  sephDT [2] = sephiDT.crop(0, 270, 270, 270);
  sephDT [3] = sephiDT.crop(270, 270, 270, 270);
  
  sephDT2 = new BufferedImage [4];
  sephDT2 [0] = sephiDT2.crop(0, 0, 270, 270);
  sephDT2 [1] = sephiDT2.crop(270, 0, 270, 270);
  sephDT2 [2] = sephiDT2.crop(0, 270, 270, 270);
  sephDT2 [3] = sephiDT2.crop(270, 270, 270, 270);
  
  sephDA = new BufferedImage[5];
  sephDA [0] = sephiDA.crop(0, 0, 270, 345);
  sephDA [1] = sephiDA.crop(270, 0, 270, 345);
  sephDA [2] = sephiDA.crop(540, 0, 270, 345);
  sephDA [3] = sephiDA.crop(0, 345, 270, 345);
  sephDA [4] = sephiDA.crop(270, 345, 270, 345);
  
  sephDA2 = new BufferedImage[5];
  sephDA2 [0] = sephiDA2.crop(0, 0, 270, 345);
  sephDA2 [1] = sephiDA2.crop(270, 0, 270, 345);
  sephDA2 [2] = sephiDA2.crop(540, 0, 270, 345);
  sephDA2 [3] = sephiDA2.crop(0, 345, 270, 345);
  sephDA2 [4] = sephiDA2.crop(270, 345, 270, 345);
  
  sephDag = new BufferedImage [4];
  sephDag [0] = sephiDag.crop(0, 0, 128, 128);
  sephDag [1] = sephiDag.crop(128, 0, 128, 128);
  sephDag [2] = sephiDag.crop(0, 128, 128, 128);
  sephDag [3] = sephiDag.crop(128, 128, 128, 128);
  
  sephDag2 = new BufferedImage [4];
  sephDag2 [0] = sephiDag2.crop(0, 0, 127, 128);
  sephDag2 [1] = sephiDag2.crop(128, 0, 127, 128);
  sephDag2 [2] = sephiDag2.crop(0, 128, 127, 128);
  sephDag2 [3] = sephiDag2.crop(128, 128, 127, 128); 
  
  sephSong = new BufferedImage [19];
  sephSong [0] = sephiSong.crop(0, 0, 210, 225);
  sephSong [1] = sephiSong.crop(210, 0, 210, 225);
  sephSong [2] = sephiSong.crop(420, 0, 210, 225);
  sephSong [3] = sephiSong.crop(630, 0, 210, 225);
  sephSong [4] = sephiSong.crop(840, 0, 210, 225);
  sephSong [5] = sephiSong.crop(0, 225, 210, 225);
  sephSong [6] = sephiSong.crop(210, 225, 210, 225);
  sephSong [7] = sephiSong.crop(420, 225, 210, 225);
  sephSong [8] = sephiSong.crop(630, 225, 210, 225);
  sephSong [9] = sephiSong.crop(840, 225, 210, 225);
  sephSong [10] = sephiSong.crop(0, 450, 210, 225);
  sephSong [11] = sephiSong.crop(210, 450, 210, 225);
  sephSong [12] = sephiSong.crop(420, 450, 210, 225);
  sephSong [13] = sephiSong.crop(630, 450, 210, 225);
  sephSong [14] = sephiSong.crop(840, 450, 210, 225);
  sephSong [15] = sephiSong.crop(0, 675, 210, 225);
  sephSong [16] = sephiSong.crop(210, 675, 210, 225);
  sephSong [17] = sephiSong.crop(420, 675, 210, 225);
  sephSong [18] = sephiSong.crop(630, 675, 210, 225);
  
  sephSong2 = new BufferedImage [19];
  sephSong2 [0] = sephiSong2.crop(0, 0, 210, 225);
  sephSong2 [1] = sephiSong2.crop(210, 0, 210, 225);
  sephSong2 [2] = sephiSong2.crop(420, 0, 210, 225);
  sephSong2 [3] = sephiSong2.crop(630, 0, 210, 225);
  sephSong2 [4] = sephiSong2.crop(840, 0, 210, 225);
  sephSong2 [5] = sephiSong2.crop(0, 225, 210, 225);
  sephSong2 [6] = sephiSong2.crop(210, 225, 210, 225);
  sephSong2 [7] = sephiSong2.crop(420, 225, 210, 225);
  sephSong2 [8] = sephiSong2.crop(630, 225, 210, 225);
  sephSong2 [9] = sephiSong2.crop(840, 225, 210, 225);
  sephSong2 [10] = sephiSong2.crop(0, 450, 210, 225);
  sephSong2 [11] = sephiSong2.crop(210, 450, 210, 225);
  sephSong2 [12] = sephiSong2.crop(420, 450, 210, 225);
  sephSong2 [13] = sephiSong2.crop(630, 450, 210, 225);
  sephSong2 [14] = sephiSong2.crop(840, 450, 210, 225);
  sephSong2 [15] = sephiSong2.crop(0, 675, 210, 225);
  sephSong2 [16] = sephiSong2.crop(210, 675, 210, 225);
  sephSong2 [17] = sephiSong2.crop(420, 675, 210, 225);
  sephSong2 [18] = sephiSong2.crop(630, 675, 210, 225);
  
  sephUlt = new BufferedImage[12];
  sephUlt [0] = sephiUlt.crop(960, 300, 480, 300);
  sephUlt [1] = sephiUlt.crop(0, 600, 480, 300);
  sephUlt [2] = sephiUlt.crop(480, 600, 480, 300);
  sephUlt [3] = sephiUlt.crop(960, 600, 480, 300);
  sephUlt [4] = sephiUlt.crop(0, 900, 480, 300);
  sephUlt [5] = sephiUlt.crop(480, 900, 480, 300);
  sephUlt [6] = sephiUlt.crop(960, 900, 480, 300);
  sephUlt [7] = sephiUlt.crop(0, 1200, 480, 300);
  sephUlt [8] = sephiUlt.crop(480, 1200, 480, 300);
  sephUlt [9] = sephiUlt.crop(960, 1200, 480, 300);
  sephUlt [10] = sephiUlt.crop(0, 1500, 480, 300);
  sephUlt [11] = sephiUlt.crop(480, 1500, 480, 300);
  
  sephUlt2 = new BufferedImage[12];
  sephUlt2 [0] = sephiUlt2.crop(960, 300, 480, 300);
  sephUlt2 [1] = sephiUlt2.crop(0, 600, 480, 300);
  sephUlt2 [2] = sephiUlt2.crop(480, 600, 480, 300);
  sephUlt2 [3] = sephiUlt2.crop(960, 600, 480, 300);
  sephUlt2 [4] = sephiUlt2.crop(0, 900, 480, 300);
  sephUlt2 [5] = sephiUlt2.crop(480, 900, 480, 300);
  sephUlt2 [6] = sephiUlt2.crop(960, 900, 480, 300);
  sephUlt2 [7] = sephiUlt2.crop(0, 1200, 480, 300);
  sephUlt2 [8] = sephiUlt2.crop(480, 1200, 480, 300);
  sephUlt2 [9] = sephiUlt2.crop(960, 1200, 480, 300);
  sephUlt2 [10] = sephiUlt2.crop(0, 1500, 480, 300);
  sephUlt2 [11] = sephiUlt2.crop(480, 1500, 480, 300);
  
  sephF = new BufferedImage[4];
  sephF[0] = sephi1.crop(384, 0, 192, 192);
  sephF[1] = sephi1.crop(576, 0, 192, 192);
  sephF[2] = sephi1.crop(384, 192, 192, 192);
  sephF[3] = sephi1.crop(576, 192, 192, 192);
  
  sephF2 = new BufferedImage[4];
  sephF2[0] = sephi1.crop(768, 0, 192, 192);
  sephF2[1] = sephi1.crop(960, 0, 192, 192);
  sephF2[2] = sephi1.crop(768, 192, 192, 192);
  sephF2[3] = sephi1.crop(960, 192, 192, 192);
  
  sephS = new BufferedImage[3];
  sephS[0] = sephi1.crop(0, 384, 192, 192);
  sephS[1] = sephi1.crop(192, 384, 192, 192);
  sephS[2] = sephi1.crop(0, 576, 192, 192);
  
  sephS2 = new BufferedImage[3];
  sephS2[0] = sephi1.crop(384, 384, 192, 192);
  sephS2[1] = sephi1.crop(576, 384, 192, 192);
  sephS2[2] = sephi1.crop(576, 576, 192, 192);
  
  //grayson stuff 
  
  grayAbils = new BufferedImage[6];
  grayAbils[0] = graysAbils.crop(0, 0, 64, 64);
  grayAbils[1] = graysAbils.crop(64, 64, 64, 64);
  grayAbils[2] = graysAbils.crop(64, 0, 64, 64);
  grayAbils[3] = graysAbils.crop(0, 128, 64, 64);
  grayAbils[4] = graysAbils.crop(0, 64, 64, 64);   
  grayAbils[5] = graysAbils.crop(64, 128, 64, 64);
  
  grayN = new BufferedImage[2];
  grayN [0] = grays1.crop(0, 0, 192, 192);
  grayN [1] = grays1.crop(0, 192, 192, 192);
  
  grayN2 = new BufferedImage[2];
  grayN2 [0] = grays1.crop(192, 0, 192, 192);
  grayN2 [1] = grays1.crop(192, 192, 192, 192);
  
  grayML = new BufferedImage[3];
  grayML [0] = grays1.crop(384, 768, 192, 192);
  grayML [1] = grays1.crop(576, 768, 192, 192);
  grayML [2] = grays1.crop(384, 960, 192, 192);
  
  grayMR = new BufferedImage[3];
  grayMR [0] = grays1.crop(768, 768, 192, 192);
  grayMR [1] = grays1.crop(960, 768, 192, 192);
  grayMR [2] = grays1.crop(768, 960, 192, 192);
  
  grayMU = new BufferedImage[3];
  grayMU [0] = grays1.crop(768, 384, 192, 192);
  grayMU [1] = grays1.crop(960, 384, 192, 192);
  grayMU [2] = grays1.crop(768, 576, 192, 192);
  
  grayMD = new BufferedImage[3];
  grayMD [0] = grays1.crop(0, 768, 192, 192);
  grayMD [1] = grays1.crop(192, 768, 192, 192);
  grayMD [2] = grays1.crop(0, 960, 192, 192);
  
  grayLA = new BufferedImage[7];
  grayLA [0] = graysLA.crop(0, 0, 270, 150);
  grayLA [1] = graysLA.crop(270, 0, 270, 150);
  grayLA [2] = graysLA.crop(0, 150, 270, 150);
  grayLA [3] = graysLA.crop(270, 150, 270, 150);
  grayLA [4] = graysLA.crop(0, 300, 270, 150);
  grayLA [5] = graysLA.crop(270, 300, 270, 150);
  grayLA [6] = graysLA.crop (0, 450, 270, 150);
  
  grayLA2 = new BufferedImage[7];
  grayLA2 [0] = graysLA2.crop(0, 0, 270, 150);
  grayLA2 [1] = graysLA2.crop(270, 0, 270, 150);
  grayLA2 [2] = graysLA2.crop(0, 150, 270, 150);
  grayLA2 [3] = graysLA2.crop(270, 150, 270, 150);
  grayLA2 [4] = graysLA2.crop(0, 300, 270, 150);
  grayLA2 [5] = graysLA2.crop(270, 300, 270, 150);
  grayLA2 [6] = graysLA2.crop (0, 450, 270, 150);
  
  grayHA = new BufferedImage[7];
  grayHA [0] = graysHA.crop(0, 0, 270, 150);
  grayHA [1] = graysHA.crop(270, 0, 270, 150);
  grayHA [2] = graysHA.crop(0, 150, 270, 150);
  grayHA [3] = graysHA.crop(270, 150, 270, 150);
  grayHA [4] = graysHA.crop(0, 300, 270, 150);
  grayHA [5] = graysHA.crop(270, 300, 270, 150);
  grayHA [6] = graysHA.crop(0, 450, 270, 150);
  
  grayHA2 = new BufferedImage[7];
  grayHA2 [0] = graysHA2.crop(0, 0, 270, 150);
  grayHA2 [1] = graysHA2.crop(270, 0, 270, 150);
  grayHA2 [2] = graysHA2.crop(0, 150, 270, 150);
  grayHA2 [3] = graysHA2.crop(270, 150, 270, 150);
  grayHA2 [4] = graysHA2.crop(0, 300, 270, 150);
  grayHA2 [5] = graysHA2.crop(270, 300, 270, 150);
  grayHA2 [6] = graysHA2.crop(0, 450, 270, 150);
  
  graySS = new BufferedImage[11];
  graySS [0] = graysSS.crop(0, 0, 300, 210);
  graySS [1] = graysSS.crop(600, 0, 300, 210);
  graySS [2] = graysSS.crop(0, 210, 300, 210);
  graySS [3] = graysSS.crop(300, 210, 300, 210);
  graySS [4] = graysSS.crop(600, 210, 300, 210);
  graySS [5] = graysSS.crop(0, 420, 300, 210);
  graySS [6] = graysSS.crop(300, 420, 300, 210);
  graySS [7] = graysSS.crop(600, 420, 300, 210);
  graySS [8] = graysSS.crop(0, 630, 300, 210);
  graySS [9] = graysSS.crop(300, 630, 300, 210);
  graySS [10] = graysSS.crop(600, 630, 300, 210);
  
  graySS2 = new BufferedImage[11];
  graySS2 [0] = graysSS2.crop(0, 0, 300, 210);
  graySS2 [1] = graysSS2.crop(600, 0, 300, 210);
  graySS2 [2] = graysSS2.crop(0, 210, 300, 210);
  graySS2 [3] = graysSS2.crop(300, 210, 300, 210);
  graySS2 [4] = graysSS2.crop(600, 210, 300, 210);
  graySS2 [5] = graysSS2.crop(0, 420, 300, 210);
  graySS2 [6] = graysSS2.crop(300, 420, 300, 210);
  graySS2 [7] = graysSS2.crop(600, 420, 300, 210);
  graySS2 [8] = graysSS2.crop(0, 630, 300, 210);
  graySS2 [9] = graysSS2.crop(300, 630, 300, 210);
  graySS2 [10] = graysSS2.crop(600, 630, 300, 210);
  
  grayRS = new BufferedImage[12];
  grayRS [0] = graysRS.crop(0, 0, 390, 210);
  grayRS [1] = graysRS.crop(390, 0, 390, 210);
  grayRS [2] = graysRS.crop(780, 0, 390, 210);
  grayRS [3] = graysRS.crop(0, 210, 390, 210);
  grayRS [4] = graysRS.crop(390, 210, 390, 210);
  grayRS [5] = graysRS.crop(780, 210, 390, 210);
  grayRS [6] = graysRS.crop(0, 420, 390, 210);
  grayRS [7] = graysRS.crop(390, 420, 390, 210);
  grayRS [8] = graysRS.crop(780, 420, 390, 210);
  grayRS [9] = graysRS.crop(0, 630, 390, 210);
  grayRS [10] = graysRS.crop(390, 630, 390, 210);
  grayRS [11] = graysRS.crop(780, 630, 390, 210);
    
  grayRS2 = new BufferedImage[12];
  grayRS2 [0] = graysRS2.crop(0, 0, 390, 210);
  grayRS2 [1] = graysRS2.crop(390, 0, 390, 210);
  grayRS2 [2] = graysRS2.crop(780, 0, 390, 210);
  grayRS2 [3] = graysRS2.crop(0, 210, 390, 210);
  grayRS2 [4] = graysRS2.crop(390, 210, 390, 210);
  grayRS2 [5] = graysRS2.crop(780, 210, 390, 210);
  grayRS2 [6] = graysRS2.crop(0, 420, 390, 210);
  grayRS2 [7] = graysRS2.crop(390, 420, 390, 210);
  grayRS2 [8] = graysRS2.crop(780, 420, 390, 210);
  grayRS2 [9] = graysRS2.crop(0, 630, 390, 210);
  grayRS2 [10] = graysRS2.crop(390, 630, 390, 210);
  grayRS2 [11] = graysRS2.crop(780, 630, 390, 210);
  
  graySC = new BufferedImage[7];
  graySC [0] = graysSC.crop(0, 0, 330, 210);
  graySC [1] = graysSC.crop(330, 0, 330, 210);
  graySC [2] = graysSC.crop(0, 210, 330, 210);
  graySC [3] = graysSC.crop(330, 210, 330, 210);
  graySC [4] = graysSC.crop(0, 420, 330, 210);
  graySC [5] = graysSC.crop(330, 420, 330, 210);
  graySC [6] = graysSC.crop(0, 630, 330, 210);
  
  graySC2 = new BufferedImage[7];
  graySC2 [0] = graysSC2.crop(0, 0, 330, 210);
  graySC2 [1] = graysSC2.crop(330, 0, 330, 210);
  graySC2 [2] = graysSC2.crop(0, 210, 330, 210);
  graySC2 [3] = graysSC2.crop(330, 210, 330, 210);
  graySC2 [4] = graysSC2.crop(0, 420, 330, 210);
  graySC2 [5] = graysSC2.crop(330, 420, 330, 210);
  graySC2 [6] = graysSC2.crop(0, 630, 330, 210);
  
  grayUC = new BufferedImage[10];
  grayUC [0] = graysUC.crop(0, 0, 240, 240);
  grayUC [1] = graysUC.crop(240, 0, 240, 240);
  grayUC [2] = graysUC.crop(480, 0, 240, 240);
  grayUC [3] = graysUC.crop(0, 240, 240, 240);
  grayUC [4] = graysUC.crop(240, 240, 240, 240);
  grayUC [5] = graysUC.crop(480, 240, 240, 240);
  grayUC [6] = graysUC.crop(0, 480, 240, 240);
  grayUC [7] = graysUC.crop(240, 480, 240, 240);
  grayUC [8] = graysUC.crop(480, 480, 240, 240);
  grayUC [9] = graysUC.crop(0, 720, 240, 240);
  
  grayUC2 = new BufferedImage[10];
  grayUC2 [0] = graysUC2.crop(0, 0, 240, 240);
  grayUC2 [1] = graysUC2.crop(240, 0, 240, 240);
  grayUC2 [2] = graysUC2.crop(480, 0, 240, 240);
  grayUC2 [3] = graysUC2.crop(0, 240, 240, 240);
  grayUC2 [4] = graysUC2.crop(240, 240, 240, 240);
  grayUC2 [5] = graysUC2.crop(480, 240, 240, 240);
  grayUC2 [6] = graysUC2.crop(0, 480, 240, 240);
  grayUC2 [7] = graysUC2.crop(240, 480, 240, 240);
  grayUC2 [8] = graysUC2.crop(480, 480, 240, 240);
  grayUC2 [9] = graysUC2.crop(0, 720, 240, 240);
  
  grayF = new BufferedImage[3];
  grayF[0] = grays1.crop(384, 0, 192, 192);
  grayF[1] = grays1.crop(576, 0, 192, 192);
  grayF[2] = grays1.crop(384, 192, 192, 192);
  
  grayF2 = new BufferedImage[3];
  grayF2[0] = grays1.crop(768, 0, 192, 192);
  grayF2[1] = grays1.crop(960, 0, 192, 192);
  grayF2[2] = grays1.crop(768, 192, 192, 192);
  
  grayS = new BufferedImage[3];
  grayS[0] = grays1.crop(0, 384, 192, 192);
  grayS[1] = grays1.crop(192, 384, 192, 192);
  grayS[2] = grays1.crop(0, 576, 192, 192); 
  
  grayS2 = new BufferedImage[3];
  grayS2[0] = grays1.crop(384, 384, 192, 192);
  grayS2[1] = grays1.crop(576, 384, 192, 192);
  grayS2[2] = grays1.crop(384, 576, 192, 192); 
  
  arunLia = new BufferedImage[4];
  arunLia [0] = arunlia.crop(0, 0, 600, 600);
  arunLia [1] = arunlia.crop(600, 0, 600, 600);
  arunLia [2] = arunlia.crop(0, 600, 600, 600);
  arunLia [3] = arunlia.crop(600, 600, 600, 600);
  
  //Luxaar Stuff
  luxN = new BufferedImage[2];
  luxN [0] = lux1.crop(0, 0, 192, 192);
  luxN [1] = lux1.crop(0, 192, 192, 192);
  
  luxN2 = new BufferedImage[2];
  luxN2 [0] = lux1.crop(192, 0, 192, 192);
  luxN2 [1] = lux1.crop(192, 192, 192, 192);
  
  luxML = new BufferedImage[3];
  luxML [0] = lux1.crop(384, 384, 192, 192);
  luxML [1] = lux1.crop(576, 384, 192, 192);
  luxML [2] = lux1.crop(384, 576, 192, 192);
  
  luxMR = new BufferedImage[3];
  luxMR [0] = lux1.crop(0, 384, 192, 192);
  luxMR [1] = lux1.crop(192, 384, 192, 192);
  luxMR [2] = lux1.crop(0, 576, 192, 192);
  
  luxMU = new BufferedImage[3];
  luxMU [0] = lux1.crop(768, 0, 192, 192);
  luxMU [1] = lux1.crop(960, 0, 192, 192);
  luxMU [2] = lux1.crop(768, 192, 192, 192);
  
  luxMD = new BufferedImage[3];
  luxMD [0] = lux1.crop(384, 0, 192, 192);
  luxMD [1] = lux1.crop(576, 0, 192, 192);
  luxMD [2] = lux1.crop(384, 192, 192, 192);
  
  luxF = new BufferedImage[3];
  luxF [0] = lux1.crop(384, 768, 192, 192);
  luxF [1] = lux1.crop(576, 768, 192, 192);
  luxF [2] = lux1.crop(384, 960, 192, 192);
    
  luxF2 = new BufferedImage[3];
  luxF2 [0] = lux1.crop(960, 768, 192, 192);
  luxF2 [1] = lux1.crop(768, 960, 192, 192);
  luxF2 [2] = lux1.crop(960, 768, 192, 192);
  
  luxS = new BufferedImage[3];
  luxS[0] = lux1.crop(0, 768, 192, 192);
  luxS[1] = lux1.crop(192, 768, 192, 192);
  luxS[2] = lux1.crop(0, 960, 192, 192); 
  
  luxS2 = new BufferedImage[3];
  luxS2[0] = lux1.crop(768, 384, 192, 192);
  luxS2[1] = lux1.crop(960, 384, 192, 192);
  luxS2[2] = lux1.crop(768, 576, 192, 192); 
  
  luxLA = new BufferedImage[8];
  luxLA [0] = luxaLA.crop(0, 0, 192, 192);
  luxLA [1] = luxaLA.crop(192, 0, 192, 192);
  luxLA [2] = luxaLA.crop(384, 0, 192, 192);
  luxLA [3] = luxaLA.crop(0, 192, 192, 192);
  luxLA [4] = luxaLA.crop(192, 192, 192, 192);
  luxLA [5] = luxaLA.crop(384, 192, 192, 192);
  luxLA [6] = luxaLA.crop(0, 384, 192, 192);
  luxLA [7] = luxaLA.crop(192, 384, 192, 192);
  
  luxLA2 = new BufferedImage[8];
  luxLA2 [0] = luxaLA2.crop(0, 0, 192, 192);
  luxLA2 [1] = luxaLA2.crop(192, 0, 192, 192);
  luxLA2 [2] = luxaLA2.crop(384, 0, 192, 192);
  luxLA2 [3] = luxaLA2.crop(0, 192, 192, 192);
  luxLA2 [4] = luxaLA2.crop(192, 192, 192, 192);
  luxLA2 [5] = luxaLA2.crop(384, 192, 192, 192);
  luxLA2 [6] = luxaLA2.crop(0, 384, 192, 192);
  luxLA2 [7] = luxaLA2.crop(192, 384, 192, 192);
  
  luxHA = new BufferedImage[15];
  luxHA [0] = luxaHA.crop(0, 0, 192, 192);
  luxHA [1] = luxaHA.crop(192, 0, 192, 192);
  luxHA [2] = luxaHA.crop(384, 0, 192, 192);
  luxHA [3] = luxaHA.crop(576, 0, 192, 192);
  luxHA [4] = luxaHA.crop(0, 192, 192, 192);
  luxHA [5] = luxaHA.crop(192, 192, 192, 192);
  luxHA [6] = luxaHA.crop(384, 192, 192, 192);
  luxHA [7] = luxaHA.crop(576, 192, 192, 192);
  luxHA [8] = luxaHA.crop(0, 384, 192, 192);
  luxHA [9] = luxaHA.crop(192, 384, 192, 192);
  luxHA [10] = luxaHA.crop(384, 384, 192, 192);
  luxHA [11] = luxaHA.crop(576, 384, 192, 192);
  luxHA [12] = luxaHA.crop(0, 576, 192, 192);
  luxHA [13] = luxaHA.crop(192, 576, 192, 192);
  luxHA [14] = luxaHA.crop(384, 576, 192, 192);
  
  luxHA2 = new BufferedImage[15];
  luxHA2 [0] = luxaHA2.crop(0, 0, 192, 192);
  luxHA2 [1] = luxaHA2.crop(192, 0, 192, 192);
  luxHA2 [2] = luxaHA2.crop(384, 0, 192, 192);
  luxHA2 [3] = luxaHA2.crop(576, 0, 192, 192);
  luxHA2 [4] = luxaHA2.crop(0, 192, 192, 192);
  luxHA2 [5] = luxaHA2.crop(192, 192, 192, 192);
  luxHA2 [6] = luxaHA2.crop(384, 192, 192, 192);
  luxHA2 [7] = luxaHA2.crop(576, 192, 192, 192);
  luxHA2 [8] = luxaHA2.crop(0, 384, 192, 192);
  luxHA2 [9] = luxaHA2.crop(192, 384, 192, 192);
  luxHA2 [10] = luxaHA2.crop(384, 384, 192, 192);
  luxHA2 [11] = luxaHA2.crop(576, 384, 192, 192);
  luxHA2 [12] = luxaHA2.crop(0, 576, 192, 192);
  luxHA2 [13] = luxaHA2.crop(192, 576, 192, 192);
  luxHA2 [14] = luxaHA2.crop(384, 576, 192, 192);
  
  luxRS = new BufferedImage [8];
  luxRS[0] = luxaRS.crop(0, 0, 192, 192);
  luxRS[1] = luxaRS.crop(192, 0, 192, 192);
  luxRS[2] = luxaRS.crop(0, 0, 192, 192);
  luxRS[3] = luxaRS.crop(192, 192, 192, 192);
  luxRS[4] = luxaRS.crop(384, 192, 192, 192);
  luxRS[5] = luxaRS.crop(0, 384, 192, 192);
  luxRS[6] = luxaRS.crop(192, 384, 192, 192);
  luxRS[7] = luxaRS.crop(384, 384, 192, 192);
  
  luxRS2 = new BufferedImage [8];
  luxRS2[0] = luxaRS2.crop(0, 0, 192, 192);
  luxRS2[1] = luxaRS2.crop(192, 0, 192, 192);
  luxRS2[2] = luxaRS2.crop(0, 0, 192, 192);
  luxRS2[3] = luxaRS2.crop(192, 192, 192, 192);
  luxRS2[4] = luxaRS2.crop(384, 192, 192, 192);
  luxRS2[5] = luxaRS2.crop(0, 384, 192, 192);
  luxRS2[6] = luxaRS2.crop(192, 384, 192, 192);
  luxRS2[7] = luxaRS2.crop(384, 384, 192, 192);
  
  luxSV = new BufferedImage [6];
  luxSV [0] = luxaSV.crop(0, 0, 192, 192);
  luxSV [1] = luxaSV.crop(192, 0, 192, 192);
  luxSV [2] = luxaSV.crop(0, 192, 192, 192);
  luxSV [3] = luxaSV.crop(192, 192, 192, 192);
  luxSV [4] = luxaSV.crop(0, 384, 192, 192);
  luxSV [5] = luxaSV.crop(0, 384, 192, 192);
  
  luxSV2 = new BufferedImage [6];
  luxSV2 [0] = luxaSV2.crop(0, 0, 192, 192);
  luxSV2 [1] = luxaSV2.crop(192, 0, 192, 192);
  luxSV2 [2] = luxaSV2.crop(0, 192, 192, 192);
  luxSV2 [3] = luxaSV2.crop(192, 192, 192, 192);
  luxSV2 [4] = luxaSV2.crop(0, 384, 192, 192);
  luxSV2 [5] = luxaSV2.crop(0, 384, 192, 192);
  
  luxV = new BufferedImage [13];
  luxV [0] = luxaV.crop(0, 0, 200, 200);
  luxV [1] = luxaV.crop(200, 0, 200, 200);
  luxV [2] = luxaV.crop(400, 0, 200, 200);
  luxV [3] = luxaV.crop(600, 0, 200, 200);
  luxV [4] = luxaV.crop(0, 200, 200, 200);
  luxV [5] = luxaV.crop(200, 200, 200, 200);
  luxV [6] = luxaV.crop(400, 200, 200, 200);
  luxV [7] = luxaV.crop(600, 200, 200, 200);
  luxV [8] = luxaV.crop(0, 400, 200, 200);
  luxV [9] = luxaV.crop(200, 400, 200, 200);
  luxV [10] = luxaV.crop(400, 400, 200, 200);
  luxV [11] = luxaV.crop(600, 400, 200, 200);
  luxV [12] = luxaV.crop(0, 600, 200, 200);
  
  luxV2 = new BufferedImage [13];
  luxV2 [0] = luxaV2.crop(0, 0, 200, 200);
  luxV2 [1] = luxaV2.crop(200, 0, 200, 200);
  luxV2 [2] = luxaV2.crop(400, 0, 200, 200);
  luxV2 [3] = luxaV2.crop(600, 0, 200, 200);
  luxV2 [4] = luxaV2.crop(0, 200, 200, 200);
  luxV2 [5] = luxaV2.crop(200, 200, 200, 200);
  luxV2 [6] = luxaV2.crop(400, 200, 200, 200);
  luxV2 [7] = luxaV2.crop(600, 200, 200, 200);
  luxV2 [8] = luxaV2.crop(0, 400, 200, 200);
  luxV2 [9] = luxaV2.crop(200, 400, 200, 200);
  luxV2 [10] = luxaV2.crop(400, 400, 200, 200);
  luxV2 [11] = luxaV2.crop(600, 400, 200, 200);
  luxV2 [12] = luxaV2.crop(0, 600, 200, 200);
  
  luxUC = new BufferedImage [17];
  luxUC [0] = luxaUC.crop(0, 0, 192, 192);
  luxUC [1] = luxaUC.crop(192, 0, 192, 192);
  luxUC [2] = luxaUC.crop(384, 0, 192, 192);
  luxUC [3] = luxaUC.crop(576, 0, 192, 192);  
  luxUC [4] = luxaUC.crop(0, 192, 192, 192);
  luxUC [5] = luxaUC.crop(192, 192, 192, 192);
  luxUC [6] = luxaUC.crop(384, 192, 192, 192);
  luxUC [7] = luxaUC.crop(576, 192, 192, 192);  
  luxUC [8] = luxaUC.crop(0, 384, 192, 192);
  luxUC [9] = luxaUC.crop(192, 384, 192, 192);
  luxUC [10] = luxaUC.crop(384, 384, 192, 192);
  luxUC [11] = luxaUC.crop(576, 384, 192, 192);  
  luxUC [12] = luxaUC.crop(0, 576, 192, 192);
  luxUC [13] = luxaUC.crop(192, 576, 192, 192);
  luxUC [14] = luxaUC.crop(384, 576, 192, 192);
  luxUC [15] = luxaUC.crop(576, 576, 192, 192); 
  luxUC [16] = luxaUC.crop(0, 768, 192, 192);  
  
  luxUC2 = new BufferedImage [17];
  luxUC2 [0] = luxaUC2.crop(0, 0, 192, 192);
  luxUC2 [1] = luxaUC2.crop(192, 0, 192, 192);
  luxUC2 [2] = luxaUC2.crop(384, 0, 192, 192);
  luxUC2 [3] = luxaUC2.crop(576, 0, 192, 192);
  luxUC2 [4] = luxaUC2.crop(0, 192, 192, 192);
  luxUC2 [5] = luxaUC2.crop(192, 192, 192, 192);
  luxUC2 [6] = luxaUC2.crop(384, 192, 192, 192);
  luxUC2 [7] = luxaUC2.crop(576, 192, 192, 192);
  luxUC2 [8] = luxaUC2.crop(0, 384, 192, 192);
  luxUC2 [9] = luxaUC2.crop(192, 384, 192, 192);
  luxUC2 [10] = luxaUC2.crop(384, 384, 192, 192);
  luxUC2 [11] = luxaUC2.crop(576, 384, 192, 192);
  luxUC2 [12] = luxaUC2.crop(0, 576, 192, 192);
  luxUC2 [13] = luxaUC2.crop(192, 576, 192, 192);
  luxUC2 [14] = luxaUC2.crop(384, 576, 192, 192);
  luxUC2 [15] = luxaUC2.crop(576, 576, 192, 192);
  luxUC2 [16] = luxaUC2.crop(0, 768, 192, 192);  
  
  luxVD = new BufferedImage [6];
  luxVD [0] = luxaVD.crop(0, 0, 720, 390);
  luxVD [1] = luxaVD.crop(720, 0, 720, 390);
  luxVD [2] = luxaVD.crop(0, 390, 720, 390);
  luxVD [3] = luxaVD.crop(720, 390, 720, 390);
  luxVD [4] = luxaVD.crop(0, 780, 720, 390);
  luxVD [5] = luxaVD.crop(720, 780, 720, 390);
          
  luxAR = new BufferedImage[2];
  luxAR[0] = luxaAR.crop(0, 0, 96, 96);
  luxAR[1] = luxaAR.crop(0, 96, 96, 96);
  
  luxAR2 = new BufferedImage[2];
  luxAR2[0] = luxaAR2.crop(0, 0, 96, 96);
  luxAR2[1] = luxaAR2.crop(0, 96, 96, 96);
  
  luxAbils = new BufferedImage[6];
  luxAbils[0] = luxaAbils.crop(0, 0, 64, 64);
  luxAbils[1] = luxaAbils.crop(64, 64, 64, 64);
  luxAbils[4] = luxaAbils.crop(64, 0, 64, 64);
  luxAbils[5] = luxaAbils.crop(0, 128, 64, 64);
  luxAbils[2] = luxaAbils.crop(0, 62, 64, 64);   
  luxAbils[3] = luxaAbils.crop(64, 126, 64, 64);
  
  //alta images
  
  altN = new BufferedImage [2];
  altN [0] = alta1.crop (0, 0, 192, 192);
  altN [1] = alta1.crop (0, 192, 192, 192); 
  
  altN2 = new BufferedImage [2];
  altN2 [0] = alta1.crop (192, 0, 192, 192);
  altN2 [1] = alta1.crop (192, 192, 192, 192);
  
  altML = new BufferedImage[3];
  altML [0] = alta1.crop(1152, 0, 192, 192);
  altML [1] = alta1.crop(1344, 0, 192, 192);
  altML [2] = alta1.crop(1152, 192, 192, 192);
  
  altMR = new BufferedImage[3];
  altMR [0] = alta1.crop(0, 384, 192, 192);
  altMR [1] = alta1.crop(192, 384, 192, 192);
  altMR [2] = alta1.crop(0, 576, 192, 192);
  
  altMU = new BufferedImage[3];
  altMU [0] = alta1.crop(768, 0, 192, 192);
  altMU [1] = alta1.crop(960, 0, 192, 192);
  altMU [2] = alta1.crop(768, 192, 192, 192);
  
  altMD = new BufferedImage[3];
  altMD [0] = alta1.crop(384, 0, 192, 192);
  altMD [1] = alta1.crop(576, 0, 192, 192);
  altMD [2] = alta1.crop(384, 192, 192, 192);
  
  altS2 = new BufferedImage[3];
  altS2[0] = alta1.crop(1152, 384, 192, 192);
  altS2[1] = alta1.crop(1344, 384, 192, 192);
  altS2[2] = alta1.crop(1152, 576, 192, 192); 
  
  altS = new BufferedImage[3];
  altS[0] = alta1.crop(0, 768, 192, 192);
  altS[1] = alta1.crop(192, 768, 192, 192);
  altS[2] = alta1.crop(0, 960, 192, 192);   
  
  altF = new BufferedImage[3];
  altF[0] = alta1.crop(384, 384, 192, 192);
  altF[1] = alta1.crop(576, 384, 192, 192);
  altF[2] = alta1.crop(384, 576, 192, 192); 
  
  altF2 = new BufferedImage[3];
  altF2[0] = alta1.crop(768, 384, 192, 192);
  altF2[1] = alta1.crop(960, 384, 192, 192);
  altF2[2] = alta1.crop(768, 576, 192, 192);     
  
  altLA = new BufferedImage[7];
  altLA[0] = altaLA.crop(0, 0, 192, 300);
  altLA[1] = altaLA.crop(300, 0, 300, 192);
  altLA[2] = altaLA.crop(0, 192, 300, 192);
  altLA[3] = altaLA.crop(300, 192, 300, 192);
  altLA[4] = altaLA.crop(0, 384, 300, 192);
  altLA[5] = altaLA.crop(300, 384, 300, 192);
  altLA[6] = altaLA.crop(0, 576, 300, 192); 
  
  altLA2 = new BufferedImage[7];
  altLA2[0] = altaLA2.crop(0, 0, 300, 192);
  altLA2[1] = altaLA2.crop(300, 0, 300, 192);
  altLA2[2] = altaLA2.crop(0, 192, 300, 192);
  altLA2[3] = altaLA2.crop(300, 192, 300, 192);
  altLA2[4] = altaLA2.crop(0, 384, 300, 192);
  altLA2[5] = altaLA2.crop(300, 384, 300, 192);
  altLA2[6] = altaLA2.crop(0, 576, 300, 192); 
  
  altHA = new BufferedImage[9];
  altHA[0] = altaHA.crop(0, 0, 300, 192);
  altHA[1] = altaHA.crop(300, 0, 300, 192);
  altHA[2] = altaHA.crop(0, 192, 300, 192);
  altHA[3] = altaHA.crop(300, 192, 300, 192);
  altHA[4] = altaHA.crop(0, 384, 300, 192);
  altHA[5] = altaHA.crop(300, 384, 300, 192);
  altHA[6] = altaHA.crop(0, 576, 300, 192);
  altHA[7] = altaHA.crop(300, 576, 300, 192);
  altHA[8] = altaHA.crop(0, 768, 300, 192);
  
  altHA2 = new BufferedImage[9];
  altHA2[0] = altaHA2.crop(0, 0, 300, 192);
  altHA2[1] = altaHA2.crop(300, 0, 300, 192);
  altHA2[2] = altaHA2.crop(0, 192, 300, 192);
  altHA2[3] = altaHA2.crop(300, 192, 300, 192);
  altHA2[4] = altaHA2.crop(0, 384, 300, 192);
  altHA2[5] = altaHA2.crop(300, 384, 300, 192);
  altHA2[6] = altaHA2.crop(0, 576, 300, 192);
  altHA2[7] = altaHA2.crop(300, 576, 300, 192);
  altHA2[8] = altaHA2.crop(0, 768, 300, 192);
    
  altBB = new BufferedImage[7];
  altBB [0] = altaBB.crop(0, 0, 240, 330);
  altBB [1] = altaBB.crop(240, 0, 240, 330);
  altBB [2] = altaBB.crop(480, 0, 240, 330);
  altBB [3] = altaBB.crop(0, 330, 240, 330);
  altBB [4] = altaBB.crop(240, 330, 240, 330);
  altBB [5] = altaBB.crop(480, 330, 240, 330);  
  altBB [6] = altaBB.crop(0, 660, 240, 330);
  
  altBB2 = new BufferedImage[7];
  altBB2 [0] = altaBB2.crop(0, 0, 240, 330);
  altBB2 [1] = altaBB2.crop(240, 0, 240, 330);
  altBB2 [2] = altaBB2.crop(480, 0, 240, 330);
  altBB2 [3] = altaBB2.crop(0, 330, 240, 330);
  altBB2 [4] = altaBB2.crop(240, 330, 240, 330);
  altBB2 [5] = altaBB2.crop(480, 330, 240, 330);  
  altBB2 [6] = altaBB2.crop(0, 660, 240, 330);
  
  altBI = new BufferedImage[4];
  altBI[0] = alta1.crop(384, 768, 192, 192);
  altBI[1] = alta1.crop(576, 768, 192, 192);
  altBI[2] = alta1.crop(384, 960, 192, 192);
  altBI[3] = alta1.crop(576, 960, 192, 192);
    
  altBI2 = new BufferedImage[4];
  altBI2[0] = alta1.crop(768, 768, 192, 192);
  altBI2[1] = alta1.crop(960, 768, 192, 192);
  altBI2[2] = alta1.crop(768, 960, 192, 192);
  altBI2[3] = alta1.crop(960, 960, 192, 192);  
  
  altLT = new BufferedImage [6];
  altLT[0] = altaThrow.crop(0, 0, 300, 192);
  altLT[1] = altaThrow.crop(300, 0, 300, 192);
  altLT[2] = altaThrow.crop(0, 192, 300, 192);
  altLT[3] = altaThrow.crop(300, 192, 300, 192);
  altLT[4] = altaThrow.crop(0, 384, 300, 192);
  altLT[5] = altaThrow.crop(300, 384, 300, 192);
  
  altLT2 = new BufferedImage [6];
  altLT2[0] = altaThrow2.crop(0, 0, 300, 192);
  altLT2[1] = altaThrow2.crop(300, 0, 300, 192);
  altLT2[2] = altaThrow2.crop(0, 192, 300, 192);
  altLT2[3] = altaThrow2.crop(300, 192, 300, 192);
  altLT2[4] = altaThrow2.crop(0, 384, 300, 192);
  altLT2[5] = altaThrow2.crop(300, 384, 300, 192);
  
  altLC = new BufferedImage [8];
  altLC [0] = alta2.crop(576, 192, 192, 192);
  altLC [1] = alta2.crop(768, 192, 192, 192);
  altLC [2] = alta2.crop(0, 384, 192, 192);
  altLC [3] = alta2.crop(192, 384, 192, 192);
  altLC [4] = alta2.crop(384, 384, 192, 192);
  altLC [5] = alta2.crop(576, 384, 192, 192);
  altLC [6] = alta2.crop(768, 384, 192, 192);
  altLC [7] = alta2.crop(0, 576, 192, 192);
  
  altLC2 = new BufferedImage [8];
  altLC2 [0] = alta2.crop(0, 0, 192, 192);
  altLC2 [1] = alta2.crop(192, 192, 192, 192);
  altLC2 [2] = alta2.crop(384, 192, 192, 192);
  altLC2 [3] = alta2.crop(576, 192, 192, 192);
  altLC2 [4] = alta2.crop(768, 192, 192, 192);
  altLC2 [5] = alta2.crop(0, 384, 192, 192);
  altLC2 [6] = alta2.crop(192, 384, 192, 192);
  altLC2 [7] = alta2.crop(384, 384, 192, 192);
  
  altLL = new BufferedImage[7];
  altLL [0] = altaLand.crop(0, 0, 240, 330);
  altLL [1] = altaLand.crop(240, 0, 240, 330);
  altLL [2] = altaLand.crop(480, 0, 240, 330);
  altLL [3] = altaLand.crop(0, 330, 240, 330);
  altLL [4] = altaLand.crop(240, 330, 240, 330);
  altLL [5] = altaLand.crop(480, 330, 240, 330);  
  altLL [6] = altaLand.crop(0, 660, 240, 330);
  
  altLL2 = new BufferedImage[7];
  altLL2 [0] = altaLand2.crop(0, 0, 240, 330);
  altLL2 [1] = altaLand2.crop(240, 0, 240, 330);
  altLL2 [2] = altaLand2.crop(480, 0, 240, 330);
  altLL2 [3] = altaLand2.crop(0, 330, 240, 330);
  altLL2 [4] = altaLand2.crop(240, 330, 240, 330);
  altLL2 [5] = altaLand2.crop(480, 330, 240, 330);  
  altLL2 [6] = altaLand2.crop(0, 660, 240, 330);
  
  altMark = new BufferedImage[3];
  altMark [0] = alta2.crop(768, 768, 192, 192);
  altMark [1] = alta2.crop(0, 960, 192, 192);
  altMark [2] = alta2.crop(192, 960, 192, 192);
  
  altI = new BufferedImage[8];
  altI [0] = alta2.crop(192, 576, 192, 192);
  altI [1] = alta2.crop(384, 576, 192, 192);
  altI [2] = alta2.crop(576, 576, 192, 192);
  altI [3] = alta2.crop(768, 576, 192, 192);
  altI [4] = alta2.crop(0, 768, 192, 192);
  altI [5] = alta2.crop(192, 768, 192, 192);
  altI [6] = alta2.crop(384, 768, 192, 192);
  altI [7] = alta2.crop(576, 768, 192, 192);
  
  altBF = new BufferedImage[4];
  altBF[0] = alta1.crop(1152, 768, 192, 192);
  altBF[1] = alta1.crop(1344, 768, 192, 192);
  altBF[2] = alta1.crop(1152, 960, 192, 192);
  altBF[3] = alta1.crop(1344, 960, 192, 192);
    
  altBF2 = new BufferedImage[4];
  altBF2[0] = alta1.crop(0, 1152, 192, 192);
  altBF2[1] = alta1.crop(192, 1152, 192, 192);
  altBF2[2] = alta1.crop(0, 1344, 192, 192);
  altBF2[3] = alta1.crop(192, 1344, 192, 192);
    
  altFW = new BufferedImage[7];
  altFW [0] = altaFW.crop(0, 0, 192, 192);
  altFW [1] = altaFW.crop(192, 0, 192, 192);
  altFW [2] = altaFW.crop(384, 0, 192, 192);
  altFW [3] = altaFW.crop(0, 192, 192, 192);
  altFW [4] = altaFW.crop(192, 192, 192, 192);
  altFW [5] = altaFW.crop(384, 192, 192, 192);
  altFW [6] = altaFW.crop(0, 384, 192, 192);
  
  altFW2 = new BufferedImage[7];
  altFW2 [0] = altaFW2.crop(0, 0, 192, 192);
  altFW2 [1] = altaFW2.crop(192, 0, 192, 192);
  altFW2 [2] = altaFW2.crop(384, 0, 192, 192);
  altFW2 [3] = altaFW2.crop(0, 192, 192, 192);
  altFW2 [4] = altaFW2.crop(192, 192, 192, 192);
  altFW2 [5] = altaFW2.crop(384, 192, 192, 192);
  altFW2 [6] = altaFW2.crop(0, 384, 192, 192);
  
  altUC = new BufferedImage[28];
  altUC [0] = altaUC.crop(0, 0, 192, 192);
  altUC [1] = altaUC.crop(192, 0, 192, 192);
  altUC [2] = altaUC.crop(384, 0, 192, 192);
  altUC [3] = altaUC.crop(576, 0, 192, 192);
  altUC [4] = altaUC.crop(0, 192, 192, 192);
  altUC [5] = altaUC.crop(192, 192, 192, 192);
  altUC [6] = altaUC.crop(384, 192, 192, 192);
  altUC [7] = altaUC.crop(576, 192, 192, 192);
  altUC [8] = altaUC.crop(0, 384, 192, 192);
  altUC [9] = altaUC.crop(192, 384, 192, 192);
  altUC [10] = altaUC.crop(384, 384, 192, 192);
  altUC [11] = altaUC.crop(576, 384, 192, 192);
  altUC [12] = altaUC.crop(0, 576, 192, 192);
  altUC [13] = altaUC.crop(192, 576, 192, 192);
  altUC [14] = altaUC.crop(384, 576, 192, 192);
  altUC [15] = altaUC.crop(576, 768, 192, 192);
  altUC [16] = altaUC.crop(0, 768, 192, 192);
  altUC [17] = altaUC.crop(192, 768, 192, 192);
  altUC [18] = altaUC.crop(384, 768, 192, 192);
  altUC [19] = altaUC.crop(576, 768, 192, 192);
  altUC [20] = altaUC.crop(384, 768, 192, 192);
  altUC [21] = altaUC.crop(576, 768, 192, 192);
  altUC [22] = altaUC.crop(384, 768, 192, 192);
  altUC [23] = altaUC.crop(576, 768, 192, 192);
  altUC [24] = altaUC.crop(384, 768, 192, 192);
  altUC [25] = altaUC.crop(576, 768, 192, 192);
  altUC [26] = altaUC.crop(384, 768, 192, 192);
  altUC [27] = altaUC.crop(576, 768, 192, 192);
  
  altUC2 = new BufferedImage[28];
  altUC2 [0] = altaUC2.crop(0, 0, 192, 192);
  altUC2 [1] = altaUC2.crop(192, 0, 192, 192);
  altUC2 [2] = altaUC2.crop(384, 0, 192, 192);
  altUC2 [3] = altaUC2.crop(576, 0, 192, 192);
  altUC2 [4] = altaUC2.crop(0, 192, 192, 192);
  altUC2 [5] = altaUC2.crop(192, 192, 192, 192);
  altUC2 [6] = altaUC2.crop(384, 192, 192, 192);
  altUC2 [7] = altaUC2.crop(576, 192, 192, 192);
  altUC2 [8] = altaUC2.crop(0, 384, 192, 192);
  altUC2 [9] = altaUC2.crop(192, 384, 192, 192);
  altUC2 [10] = altaUC2.crop(384, 384, 192, 192);
  altUC2 [11] = altaUC2.crop(576, 384, 192, 192);
  altUC2 [12] = altaUC2.crop(0, 576, 192, 192);
  altUC2 [13] = altaUC2.crop(192, 576, 192, 192);
  altUC2 [14] = altaUC2.crop(384, 576, 192, 192);
  altUC2 [15] = altaUC2.crop(576, 768, 192, 192);
  altUC2 [16] = altaUC2.crop(0, 768, 192, 192);
  altUC2 [17] = altaUC2.crop(192, 768, 192, 192);
  altUC2 [18] = altaUC2.crop(384, 768, 192, 192);
  altUC2 [19] = altaUC2.crop(576, 768, 192, 192);
  altUC2 [20] = altaUC2.crop(384, 768, 192, 192);
  altUC2 [21] = altaUC2.crop(576, 768, 192, 192);
  altUC2 [22] = altaUC2.crop(384, 768, 192, 192);
  altUC2 [23] = altaUC2.crop(576, 768, 192, 192);
  altUC2 [24] = altaUC2.crop(384, 768, 192, 192);
  altUC2 [25] = altaUC2.crop(576, 768, 192, 192);
  altUC2 [26] = altaUC2.crop(384, 768, 192, 192);
  altUC2 [27] = altaUC2.crop(576, 768, 192, 192);
  
  altWave = new BufferedImage[1];
  altWave[0] = altaWave.crop(0, 0, 192, 192);
  
  altWave2 = new BufferedImage[1];
  altWave2[0] = altaWave2.crop(0, 0, 192, 192);
  
  tSurge = new BufferedImage[20];
  tSurge[0] = thundSurge.crop(0, 0, 1500, 900);
  tSurge[1] = thundSurge.crop(1500, 0, 1500, 900);
  tSurge[2] = thundSurge.crop(0, 900, 1500, 900);
  tSurge[3] = thundSurge.crop(1500, 900, 1500, 900);
  tSurge[4] = thundSurge.crop(0, 1800, 1500, 900);
  tSurge[5] = thundSurge.crop(0, 900, 1500, 900);
  tSurge[6] = thundSurge.crop(1500, 900, 1500, 900);
  tSurge[7] = thundSurge.crop(0, 1800, 1500, 900);
  tSurge[8] = thundSurge.crop(0, 900, 1500, 900);
  tSurge[9] = thundSurge.crop(1500, 900, 1500, 900);
  tSurge[10] = thundSurge.crop(0, 1800, 1500, 900);
  tSurge[11] = thundSurge.crop(0, 900, 1500, 900);
  tSurge[12] = thundSurge.crop(1500, 900, 1500, 900);
  tSurge[13] = thundSurge.crop(0, 1800, 1500, 900);
  tSurge[14] = thundSurge.crop(0, 900, 1500, 900);
  tSurge[15] = thundSurge.crop(1500, 900, 1500, 900);
  tSurge[16] = thundSurge.crop(0, 1800, 1500, 900); 
  tSurge[17] = thundSurge.crop(0, 900, 1500, 900);
  tSurge[18] = thundSurge.crop(1500, 900, 1500, 900);
  tSurge[19] = thundSurge.crop(0, 1800, 1500, 900);  
  
  altChain = new BufferedImage[3];
  altChain [0] = altaChain.crop(0, 0, 128, 128);
  altChain [1] = altaChain.crop(128, 0, 128, 128);
  altChain [2] = altaChain.crop(0, 128, 128, 128);
  
  altAbils = new BufferedImage[6];
  altAbils[0] = altaAbils.crop(0, 0, 64, 64);
  altAbils[1] = altaAbils.crop(64, 64, 64, 64);
  altAbils[4] = altaAbils.crop(64, 0, 64, 64);
  altAbils[5] = altaAbils.crop(0, 128, 64, 64);
  altAbils[2] = altaAbils.crop(0, 64, 64, 64);   
  altAbils[3] = altaAbils.crop(64, 128, 64, 64);
  
  ironN = new BufferedImage[2];
  ironN[0] = iron1.crop(0, 0, 192, 192);
  ironN[1] = iron1.crop(0, 192, 192, 192);
  
  ironN2 = new BufferedImage[2];
  ironN2[0] = iron1.crop(192, 0, 192, 192);
  ironN2[1] = iron1.crop(192, 192, 192, 192); 
  
  ironML = new BufferedImage[3];
  ironML [0] = iron1.crop(384, 0, 192, 192);
  ironML [1] = iron1.crop(576, 0, 192, 192);
  ironML [2] = iron1.crop(384, 192, 192, 192);
  
  ironMR = new BufferedImage[3];
  ironMR [0] = iron1.crop(768, 0, 192, 192);
  ironMR [1] = iron1.crop(960, 0, 192, 192);
  ironMR [2] = iron1.crop(768, 192, 192, 192);
  
  ironMU = new BufferedImage[3];
  ironMU [0] = iron1.crop(0, 384, 192, 192);
  ironMU [1] = iron1.crop(192, 384, 192, 192);
  ironMU [2] = iron1.crop(0, 576, 192, 192);
  
  ironMD = new BufferedImage[3];
  ironMD [0] = iron1.crop(384, 384, 192, 192);
  ironMD [1] = iron1.crop(576, 384, 192, 192);
  ironMD [2] = iron1.crop(384, 576, 192, 192);

  ironS = new BufferedImage[3];
  ironS[0] = iron1.crop(0, 768, 192, 192);
  ironS[1] = iron1.crop(192, 768, 192, 192);
  ironS[2] = iron1.crop(0, 960, 192, 192);   
  
  ironS2 = new BufferedImage[3];
  ironS2[0] = iron1.crop(768, 384, 192, 192);
  ironS2[1] = iron1.crop(960, 384, 192, 192);
  ironS2[2] = iron1.crop(768, 576, 192, 192); 
  
  ironF = new BufferedImage[3];
  ironF[0] = iron1.crop(384, 768, 192, 192);
  ironF[1] = iron1.crop(576, 960, 192, 192);
  ironF[2] = iron1.crop(384, 960, 192, 192); 
  
  ironF2 = new BufferedImage[3];
  ironF2[0] = iron1.crop(768, 768, 192, 192);
  ironF2[1] = iron1.crop(768, 960, 192, 192);
  ironF2[2] = iron1.crop(960, 960, 192, 192);     
  
  ironLA = new BufferedImage[7];
  ironLA[0] = ironfLA.crop(0, 0, 192, 192);
  ironLA[1] = ironfLA.crop(192, 0, 192, 192);
  ironLA[2] = ironfLA.crop(384, 0, 192, 192);
  ironLA[3] = ironfLA.crop(0, 192, 192, 192);
  ironLA[4] = ironfLA.crop(192, 192, 192, 192);
  ironLA[5] = ironfLA.crop(384, 192, 192, 192);
  ironLA[6] = ironfLA.crop(0, 384, 192, 192);
  
  ironLA2 = new BufferedImage[7];
  ironLA2[0] = ironfLA2.crop(0, 0, 192, 192);
  ironLA2[1] = ironfLA2.crop(192, 0, 192, 192);
  ironLA2[2] = ironfLA2.crop(384, 0, 192, 192);
  ironLA2[3] = ironfLA2.crop(0, 192, 192, 192);
  ironLA2[4] = ironfLA2.crop(192, 192, 192, 192);
  ironLA2[5] = ironfLA2.crop(384, 192, 192, 192);
  ironLA2[6] = ironfLA2.crop(0, 384, 192, 192);
  
  ironHA = new BufferedImage[9];
  ironHA[0] = ironfHA.crop(0, 0, 216, 216);
  ironHA[1] = ironfHA.crop(216, 0, 216, 216);
  ironHA[2] = ironfHA.crop(432, 0, 216, 216);
  ironHA[3] = ironfHA.crop(0, 216, 216, 216);
  ironHA[4] = ironfHA.crop(216, 216, 216, 216);
  ironHA[5] = ironfHA.crop(432, 216, 216, 216);
  ironHA[6] = ironfHA.crop(0, 432, 216, 216);
  ironHA[7] = ironfHA.crop(216, 432, 216, 216);
  ironHA[8] = ironfHA.crop(384, 432, 216, 216);        
  
  ironHA2 = new BufferedImage[9];
  ironHA2[0] = ironfHA2.crop(0, 0, 216, 216);
  ironHA2[1] = ironfHA2.crop(216, 0, 216, 216);
  ironHA2[2] = ironfHA2.crop(432, 0, 216, 216);
  ironHA2[3] = ironfHA2.crop(0, 216, 216, 216);
  ironHA2[4] = ironfHA2.crop(216, 216, 216, 216);
  ironHA2[5] = ironfHA2.crop(432, 216, 216, 216);
  ironHA2[6] = ironfHA2.crop(0, 432, 216, 216);
  ironHA2[7] = ironfHA2.crop(216, 432, 216, 216);
  ironHA2[8] = ironfHA2.crop(432, 432, 216, 216);   
  
  ironSG1 = new BufferedImage[6];
  ironSG1[0] = ironfSG.crop(0, 0, 192, 192);
  ironSG1[1] = ironfSG.crop(192, 0, 192, 192);
  ironSG1[2] = ironfSG.crop(0, 192, 192, 192);
  ironSG1[3] = ironfSG.crop(192, 192, 192, 192);
  ironSG1[4] = ironfSG.crop(0, 384, 192, 192);
  ironSG1[5] = ironfSG.crop(192, 384, 192, 192);
  
  ironSG2 = new BufferedImage[6];
  ironSG2[0] = ironfSG2.crop(0, 0, 192, 192);
  ironSG2[1] = ironfSG2.crop(192, 0, 192, 192);
  ironSG2[2] = ironfSG2.crop(0, 192, 192, 192);
  ironSG2[3] = ironfSG2.crop(192, 192, 192, 192);
  ironSG2[4] = ironfSG2.crop(0, 384, 192, 192);
  ironSG2[5] = ironfSG2.crop(192, 384, 192, 192);
  
  ironI = new BufferedImage[12];
  ironI[0] = ironfI.crop(0, 0, 300, 300);
  ironI[1] = ironfI.crop(300, 0, 300, 300);
  ironI[2] = ironfI.crop(600, 0, 300, 300);
  ironI[3] = ironfI.crop(0, 300, 300, 300);
  ironI[4] = ironfI.crop(300, 300, 300, 300);
  ironI[5] = ironfI.crop(600, 300, 300, 300);
  ironI[6] = ironfI.crop(0, 600, 300, 300);
  ironI[7] = ironfI.crop(300, 600, 300, 300);
  ironI[8] = ironfI.crop(600, 600, 300, 300);
  ironI[9] = ironfI.crop(0, 900, 300, 300);
  ironI[10] = ironfI.crop(300, 900, 300, 300);
  ironI[11] = ironfI.crop(600, 900, 300, 300);

  ironRC = new BufferedImage[6];
  ironRC[0] = ironfRC.crop(0, 0, 192, 192);
  ironRC[1] = ironfRC.crop(192, 0, 192, 192);
  ironRC[2] = ironfRC.crop(0, 192, 192, 192);
  ironRC[3] = ironfRC.crop(192, 192, 192, 192);
  ironRC[4] = ironfRC.crop(0, 384, 192, 192);
  ironRC[5] = ironfRC.crop(192, 384, 192, 192);
  
  ironRC2 = new BufferedImage[6];
  ironRC2[0] = ironfRC2.crop(0, 0, 192, 192);
  ironRC2[1] = ironfRC2.crop(192, 0, 192, 192);
  ironRC2[2] = ironfRC2.crop(0, 192, 192, 192);
  ironRC2[3] = ironfRC2.crop(192, 192, 192, 192);
  ironRC2[4] = ironfRC2.crop(0, 384, 192, 192);
  ironRC2[5] = ironfRC2.crop(192, 384, 192, 192);
  
  ironWR = new BufferedImage[7];
  ironWR[0] = ironfWR.crop(0, 0, 300, 300);
  ironWR[1] = ironfWR.crop(300, 0, 300, 300);
  ironWR[2] = ironfWR.crop(600, 0, 300, 300);
  ironWR[3] = ironfWR.crop(0, 300, 300, 300);
  ironWR[4] = ironfWR.crop(300, 300, 300, 300);
  ironWR[5] = ironfWR.crop(600, 300, 300, 300);
  ironWR[6] = ironfWR.crop(0, 600, 300, 300);  
  
  ironWR2 = new BufferedImage[7];
  ironWR2[0] = ironfWR2.crop(0, 0, 300, 300);
  ironWR2[1] = ironfWR2.crop(300, 0, 300, 300);
  ironWR2[2] = ironfWR2.crop(600, 0, 300, 300);
  ironWR2[3] = ironfWR2.crop(0, 300, 300, 300);
  ironWR2[4] = ironfWR2.crop(300, 300, 300, 300);
  ironWR2[5] = ironfWR2.crop(600, 300, 300, 300);
  ironWR2[6] = ironfWR2.crop(0, 600, 300, 300);  
  
  sprintDown = new BufferedImage[3];
  sprintDown[0] = sprints.crop(0, 0, 192, 192);
  sprintDown[1] = sprints.crop(192, 0, 192, 192);
  sprintDown[2] = sprints.crop(384, 0, 192, 192);
  
  sprintUp = new BufferedImage[3];
  sprintUp[0] = sprints.crop(0, 192, 192, 192);
  sprintUp[1] = sprints.crop(192, 192, 192, 192);
  sprintUp[2] = sprints.crop(384, 192, 192, 192);
  
  sprintLeft = new BufferedImage[3];
  sprintLeft[0] = sprints.crop(0, 384, 192, 192);
  sprintLeft[1] = sprints.crop(192, 384, 192, 192);
  sprintLeft[2] = sprints.crop(384, 384, 192, 192);
  
  sprintRight = new BufferedImage[3];
  sprintRight[0] = sprints.crop(0, 576, 192, 192);
  sprintRight[1] = sprints.crop(192, 576, 192, 192);
  sprintRight[2] = sprints.crop(384, 576, 192, 192);
  
  beat = new BufferedImage[3];
  beat[0] = beatf.crop(0, 0, 300, 300);
  beat[1] = beatf.crop(300, 0, 300, 300);
  beat[2] = beatf.crop(0, 300, 300, 300);
  
  ironAbils = new BufferedImage[6];
  ironAbils[0] = ironfAbils.crop(0, 0, 64, 64);
  ironAbils[1] = ironfAbils.crop(64, 64, 64, 64);
  ironAbils[2] = ironfAbils.crop(64, 0, 64, 64);
  ironAbils[3] = ironfAbils.crop(0, 128, 64, 64);
  ironAbils[4] = ironfAbils.crop(0, 64, 64, 64);   
  ironAbils[5] = ironfAbils.crop(64, 128, 64, 64);
  
  taN = new BufferedImage[2];
  taN[0] = ta1.crop(0, 0, 192, 192);
  taN[1] = ta1.crop(0, 192, 192, 192);
  
  taN2 = new BufferedImage[2];
  taN2[0] = ta1.crop(192, 0, 192, 192);
  taN2[1] = ta1.crop(192, 192, 192, 192); 
  
  taML = new BufferedImage[3];
  taML [0] = ta1.crop(0, 384, 192, 192);
  taML [1] = ta1.crop(192, 384, 192, 192);
  taML [2] = ta1.crop(0, 576, 192, 192);
  
  taMR = new BufferedImage[3];
  taMR [0] = ta1.crop(384, 384, 192, 192);
  taMR [1] = ta1.crop(576, 384, 192, 192);
  taMR [2] = ta1.crop(384, 576, 192, 192);
  
  taMU = new BufferedImage[3];
  taMU [0] = ta1.crop(768, 384, 192, 192);
  taMU [1] = ta1.crop(960, 384, 192, 192);
  taMU [2] = ta1.crop(768, 576, 192, 192);
  
  taMD = new BufferedImage[3];
  taMD [0] = ta1.crop(0, 768, 192, 192);
  taMD [1] = ta1.crop(192, 768, 192, 192);
  taMD [2] = ta1.crop(0, 960, 192, 192);
  
  taS = new BufferedImage[3];
  taS[0] = ta1.crop(384, 768, 192, 192);
  taS[1] = ta1.crop(576, 768, 192, 192);
  taS[2] = ta1.crop(384, 960, 192, 192); 
  
  taS2 = new BufferedImage[3];
  taS2[0] = ta1.crop(768, 768, 192, 192);
  taS2[1] = ta1.crop(960, 768, 192, 192);
  taS2[2] = ta1.crop(768, 960, 192, 192);   
  
  taF = new BufferedImage[3];
  taF[0] = ta1.crop(384, 0, 192, 192);
  taF[1] = ta1.crop(576, 0, 192, 192);
  taF[2] = ta1.crop(384, 192, 192, 192); 
  
  taF2 = new BufferedImage[3];
  taF2[0] = ta1.crop(768, 0, 192, 192);
  taF2[1] = ta1.crop(960, 0, 192, 192);
  taF2[2] = ta1.crop(768, 192, 192, 192);  
  
  taLA = new BufferedImage[6];
  taLA[0] = ta2.crop(0, 0, 192, 192);
  taLA[1] = ta2.crop(192, 0, 192, 192);
  taLA[2] = ta2.crop(0, 192, 192, 192);
  taLA[3] = ta2.crop(192, 192, 192, 192);
  taLA[4] = ta2.crop(0, 384, 192, 192);
  taLA[5] = ta2.crop(192, 384, 192, 192);
  
  taLA2 = new BufferedImage[6];
  taLA2[0] = ta2.crop(384, 0, 192, 192);
  taLA2[1] = ta2.crop(576, 0, 192, 192);
  taLA2[2] = ta2.crop(384, 192, 192, 192);
  taLA2[3] = ta2.crop(576, 192, 192, 192);
  taLA2[4] = ta2.crop(384, 384, 192, 192);
  taLA2[5] = ta2.crop(576, 384, 192, 192);
  
  taHA = new BufferedImage[6];
  taHA[0] = ta2.crop(0, 576, 192, 192);
  taHA[1] = ta2.crop(192, 576, 192, 192);
  taHA[2] = ta2.crop(0, 768, 192, 192);
  taHA[3] = ta2.crop(192, 768, 192, 192);
  taHA[4] = ta2.crop(0, 960, 192, 192);
  taHA[5] = ta2.crop(192, 960, 192, 192);
  
  taHA2 = new BufferedImage[6];
  taHA2[0] = ta2.crop(384, 576, 192, 192);
  taHA2[1] = ta2.crop(576, 576, 192, 192);
  taHA2[2] = ta2.crop(384, 768, 192, 192);
  taHA2[3] = ta2.crop(576, 768, 192, 192);
  taHA2[4] = ta2.crop(384, 960, 192, 192);
  taHA2[5] = ta2.crop(576, 960, 192, 192);
  
  taFB = new BufferedImage[3];
  taFB[0] = tafFB.crop(0, 0, 192, 192);
  taFB[1] = tafFB.crop(192, 0, 192, 192);
  taFB[2] = tafFB.crop(0, 192, 192, 192);
  
  taFB2 = new BufferedImage[3];
  taFB2[0] = tafFB2.crop(0, 0, 192, 192);
  taFB2[1] = tafFB2.crop(192, 0, 192, 192);
  taFB2[2] = tafFB2.crop(0, 192, 192, 192);
  
  taFBH = new BufferedImage[3];
  taFBH[0] = tafFBH.crop(0, 0, 192, 192);
  taFBH[1] = tafFBH.crop(192, 0, 192, 192);
  taFBH[2] = tafFBH.crop(0, 192, 192, 192);
  
  taFBH2 = new BufferedImage[3];
  taFBH2[0] = tafFBH2.crop(0, 0, 192, 192);
  taFBH2[1] = tafFBH2.crop(192, 0, 192, 192);
  taFBH2[2] = tafFBH2.crop(0, 192, 192, 192);
  
  taSP = new BufferedImage[7];
  taSP[0] = tafSP.crop(0, 0, 192, 192);
  taSP[1] = tafSP.crop(192, 0, 192, 192);
  taSP[2] = tafSP.crop(384, 0, 192, 192);
  taSP[3] = tafSP.crop(0, 192, 192, 192);
  taSP[4] = tafSP.crop(192, 192, 192, 192);
  taSP[5] = tafSP.crop(384, 192, 192, 192);
  taSP[6] = tafSP.crop(0, 384, 192, 192);
  
  taSP2 = new BufferedImage[7];
  taSP2[0] = tafSP2.crop(0, 0, 192, 192);
  taSP2[1] = tafSP2.crop(192, 0, 192, 192);
  taSP2[2] = tafSP2.crop(384, 0, 192, 192);
  taSP2[3] = tafSP2.crop(0, 192, 192, 192);
  taSP2[4] = tafSP2.crop(192, 192, 192, 192);
  taSP2[5] = tafSP2.crop(384, 192, 192, 192);
  taSP2[6] = tafSP2.crop(0, 384, 192, 192);
  
  taSPP = new BufferedImage[3];
  taSPP[0] = tafSPP.crop(0, 0, 192, 192);
  taSPP[1] = tafSPP.crop(192, 0, 192, 192);
  taSPP[2] = tafSPP.crop(0, 192, 192, 192);
  
  taSPP2 = new BufferedImage[3];
  taSPP2[0] = tafSPP2.crop(0, 0, 192, 192);
  taSPP2[1] = tafSPP2.crop(192, 0, 192, 192);
  taSPP2[2] = tafSPP2.crop(0, 192, 192, 192);
  
  taSB = new BufferedImage[5];
  taSB[0] = tafSB.crop(0, 0, 192, 192);
  taSB[1] = tafSB.crop(192, 0, 192, 192);
  taSB[2] = tafSB.crop(0, 192, 192, 192);
  taSB[3] = tafSB.crop(192, 192, 192, 192);
  taSB[4] = tafSB.crop(0, 384, 192, 192);       
  
  taCC = new BufferedImage[6];
  taCC[0] = tafCC.crop(0, 0, 300, 192);
  taCC[1] = tafCC.crop(0, 0, 300, 192);
  taCC[2] = tafCC.crop(300, 0, 300, 192);
  taCC[3] = tafCC.crop(0, 192, 300, 192);
  taCC[4] = tafCC.crop(300, 192, 300, 192);
  taCC[5] = tafCC.crop(0, 384, 300, 192);
  
  taCC2 = new BufferedImage[6];
  taCC2[0] = tafCC2.crop(0, 0, 300, 192);
  taCC2[1] = tafCC2.crop(0, 0, 300, 192);
  taCC2[2] = tafCC2.crop(300, 0, 300, 192);
  taCC2[3] = tafCC2.crop(0, 192, 300, 192);
  taCC2[4] = tafCC2.crop(300, 192, 300, 192);
  taCC2[5] = tafCC2.crop(0, 384, 300, 192);
  
  taFC = new BufferedImage[7];
  taFC[0] = tafFC.crop(0, 0, 576, 576);
  taFC[1] = tafFC.crop(576, 0, 576, 576);
  taFC[2] = tafFC.crop(0, 0, 576, 576);
  taFC[3] = tafFC.crop(576, 576, 576, 576);
  taFC[4] = tafFC.crop(0, 576, 576, 576);
  taFC[5] = tafFC.crop(576, 576, 576, 576);
  taFC[6] = tafFC.crop(0, 1152, 576, 576);
  
//  taUC = new BufferedImage[6];
//  taUC[0] = tafUC.crop(0, 0, 192, 300);
//  taUC[1] = tafUC.crop(192, 0, 192, 300);
//  taUC[2] = tafUC.crop(384, 0, 192, 300);
//  taUC[3] = tafUC.crop(0, 300, 192, 300);
//  taUC[4] = tafUC.crop(192, 300, 192, 300);
//  taUC[5] = tafUC.crop(384, 300, 192, 300);
  
//  taUC2 = new BufferedImage[6];
//  taUC2[0] = tafUC2.crop(0, 0, 192, 300);
//  taUC2[1] = tafUC2.crop(192, 0, 192, 300);
//  taUC2[2] = tafUC2.crop(384, 0, 192, 300);
//  taUC2[3] = tafUC2.crop(0, 300, 192, 300);
//  taUC2[4] = tafUC2.crop(192, 300, 192, 300);
//  taUC2[5] = tafUC2.crop(384, 300, 192, 300);

  taFN = new BufferedImage[6];
  taFN[0] = ta4.crop(384, 192, 192, 192);
  taFN[1] = ta4.crop(576, 192, 192, 192);
  taFN[2] = ta4.crop(0, 384, 192, 192);
  taFN[3] = ta4.crop(192, 384, 192, 192);
  taFN[4] = ta4.crop(384, 384, 192, 192);
  taFN[5] = ta4.crop(576, 384, 192, 192);
  
  taFN2 = new BufferedImage[6];
  taFN2[0] = ta4.crop(0, 0, 192, 192);
  taFN2[1] = ta4.crop(192, 0, 192, 192);
  taFN2[2] = ta4.crop(384, 0, 192, 192);
  taFN2[3] = ta4.crop(576, 0, 192, 192);
  taFN2[4] = ta4.crop(0, 192, 192, 192);
  taFN2[5] = ta4.crop(192, 192, 192, 192);
  
  taPW = new BufferedImage[7];
  taPW[0] = tafPW.crop(0, 0, 192, 384);
  taPW[1] = tafPW.crop(192, 0, 192, 384);
  taPW[2] = tafPW.crop(384, 0, 192, 384);
  taPW[3] = tafPW.crop(576, 0, 192, 384);
  taPW[4] = tafPW.crop(0, 384, 192, 384);
  taPW[5] = tafPW.crop(192, 384, 192, 384);
  taPW[6] = tafPW.crop(384, 384, 192, 384);
  
  taMFB = new BufferedImage[8];
  taMFB[0] = tafMFB.crop(0, 0, 192, 192);
  taMFB[1] = tafMFB.crop(192, 0, 192, 192);
  taMFB[2] = tafMFB.crop(384, 0, 192, 192);
  taMFB[3] = tafMFB.crop(0, 192, 192, 192);
  taMFB[4] = tafMFB.crop(192, 192, 192, 192);
  taMFB[5] = tafMFB.crop(384, 192, 192, 192);
  taMFB[6] = tafMFB.crop(0, 384, 192, 192);
  taMFB[7] = tafMFB.crop(192, 384, 192, 192);
  
  taMFB2 = new BufferedImage[8];
  taMFB2[0] = tafMFB2.crop(0, 0, 192, 192);
  taMFB2[1] = tafMFB2.crop(192, 0, 192, 192);
  taMFB2[2] = tafMFB2.crop(384, 0, 192, 192);
  taMFB2[3] = tafMFB2.crop(0, 192, 192, 192);
  taMFB2[4] = tafMFB2.crop(192, 192, 192, 192);
  taMFB2[5] = tafMFB2.crop(384, 192, 192, 192);
  taMFB2[6] = tafMFB2.crop(0, 384, 192, 192);
  taMFB2[7] = tafMFB2.crop(192, 384, 192, 192);
   
  taFLA2 = new BufferedImage[4];
  taFLA2[0] = ta4.crop(0, 576, 192, 192);
  taFLA2[1] = ta4.crop(192, 576, 192, 192);
  taFLA2[2] = ta4.crop(384, 576, 192, 192);
  taFLA2[3] = ta4.crop(576, 576, 192, 192);
  
  taFLA = new BufferedImage[4];
  taFLA[0] = ta4.crop(0, 768, 192, 192);
  taFLA[1] = ta4.crop(192, 768, 192, 192);
  taFLA[2] = ta4.crop(384, 768, 192, 192);
  taFLA[3] = ta4.crop(576, 768, 192, 192);
  
  taFL = new BufferedImage[7];
  taFL[0] = ta3.crop(0, 0, 330, 240);
  taFL[1] = ta3.crop(330, 0, 330, 240);
  taFL[2] = ta3.crop(660, 0, 330, 240);
  taFL[3] = ta3.crop(990, 0, 330, 240);
  taFL[4] = ta3.crop(0, 240, 330, 240);
  taFL[5] = ta3.crop(330, 0, 330, 240);
  taFL[6] = ta3.crop(660, 0, 330, 240);
  
  taFL2 = new BufferedImage[7];
  taFL2[0] = ta3.crop(990, 240, 330, 240);
  taFL2[1] = ta3.crop(0, 480, 330, 240);
  taFL2[2] = ta3.crop(330, 480, 330, 240);
  taFL2[3] = ta3.crop(660, 480, 330, 240);
  taFL2[4] = ta3.crop(990, 480, 330, 240);
  taFL2[5] = ta3.crop(0, 480, 330, 240);
  taFL2[6] = ta3.crop(330, 480, 330, 240);
  
  taFG = new BufferedImage[6];
  taFG[0] = ta3.crop(660, 720, 330, 240);
  taFG[1] = ta3.crop(990, 720, 330, 240);
  taFG[2] = ta3.crop(0, 960, 330, 240);
  taFG[3] = ta3.crop(330, 960, 330, 240);
  taFG[4] = ta3.crop(660, 960, 330, 240);
  taFG[5] = ta3.crop(990, 960, 330, 240);
  
  taFG2 = new BufferedImage[6];
  taFG2[0] = ta3.crop(0, 1200, 330, 240);
  taFG2[1] = ta3.crop(330, 1200, 330, 240);
  taFG2[2] = ta3.crop(660, 1200, 330, 240);
  taFG2[3] = ta3.crop(990, 1200, 330, 240);
  taFG2[4] = ta3.crop(0, 1440, 330, 240);
  taFG2[5] = ta3.crop(330, 1440, 330, 240);
  
  tof = new BufferedImage[3];
  tof[0] = taftof.crop(0, 0, 192, 192);
  tof[1] = taftof.crop(192, 0, 192, 192);
  tof[2] = taftof.crop(0, 192, 192, 192);
  
  taAbils = new BufferedImage[6];
  taAbils[0] = tafAbils.crop(0, 0, 64, 64);
  taAbils[1] = tafAbils.crop(64, 64, 64, 64);
  taAbils[4] = tafAbils.crop(64, 0, 64, 64);
  taAbils[5] = tafAbils.crop(0, 128, 64, 64);
  taAbils[2] = tafAbils.crop(0, 64, 64, 64);   
  taAbils[3] = tafAbils.crop(64, 128, 64, 64);
  
  //Lauda sprites
  laN = new BufferedImage[2];
  laN[0] = la1.crop(0, 0, 192, 192);
  laN[1] = la1.crop(0, 192, 192, 192);
  
  laN2 = new BufferedImage[2];
  laN2[0] = la1.crop(192, 0, 192, 192);
  laN2[1] = la1.crop(192, 192, 192, 192); 
  
  laML = new BufferedImage[3];
  laML [0] = la1.crop(384, 0, 192, 192);
  laML [1] = la1.crop(576, 0, 192, 192);
  laML [2] = la1.crop(384, 192, 192, 192);
  
  laMR = new BufferedImage[3];
  laMR [0] = la1.crop(768, 0, 192, 192);
  laMR [1] = la1.crop(960, 0, 192, 192);
  laMR [2] = la1.crop(768, 192, 192, 192);
  
  laMU = new BufferedImage[3];
  laMU [0] = la1.crop(0, 384, 192, 192);
  laMU [1] = la1.crop(192, 384, 192, 192);
  laMU [2] = la1.crop(0, 576, 192, 192);
 
  laMD = new BufferedImage[3];
  laMD [0] = la1.crop(384, 384, 192, 192);
  laMD [1] = la1.crop(576, 384, 192, 192);
  laMD [2] = la1.crop(384, 576, 192, 192);
  
  laS = new BufferedImage[3];
  laS[0] = la1.crop(768, 384, 192, 192);
  laS[1] = la1.crop(960, 384, 192, 192);
  laS[2] = la1.crop(768, 576, 192, 192); 
  
  laS2 = new BufferedImage[3];
  laS2[0] = la1.crop(0, 768, 192, 192);
  laS2[1] = la1.crop(192, 768, 192, 192);
  laS2[2] = la1.crop(0, 960, 192, 192);   
  
  laF = new BufferedImage[3];
  laF[0] = la1.crop(384, 768, 192, 192);
  laF[1] = la1.crop(576, 768, 192, 192);
  laF[2] = la1.crop(384, 960, 192, 192); 
  
  laF2 = new BufferedImage[3];
  laF2[0] = la1.crop(768, 768, 192, 192);
  laF2[1] = la1.crop(960, 768, 192, 192);
  laF2[2] = la1.crop(768, 960, 192, 192);
  
  laLA = new BufferedImage[5];
  laLA[0] = lafLA.crop(0, 0, 192, 192);
  laLA[1] = lafLA.crop(192, 0, 192, 192);
  laLA[2] = lafLA.crop(0, 192, 192, 192);
  laLA[3] = lafLA.crop(192, 192, 192, 192);
  laLA[4] = lafLA.crop(0, 384, 192, 192);
  
  laLA2 = new BufferedImage[5];
  laLA2[0] = lafLA2.crop(0, 0, 192, 192);
  laLA2[1] = lafLA2.crop(192, 0, 192, 192);
  laLA2[2] = lafLA2.crop(0, 192, 192, 192);
  laLA2[3] = lafLA2.crop(192, 192, 192, 192);
  laLA2[4] = lafLA2.crop(0, 384, 192, 192);
  
  laHA = new BufferedImage[6];
  laHA[0] = lafHA.crop(0, 0, 216, 192);
  laHA[1] = lafHA.crop(216, 0, 216, 192);
  laHA[2] = lafHA.crop(0, 192, 216, 192);
  laHA[3] = lafHA.crop(216, 192, 216, 192);
  laHA[4] = lafHA.crop(0, 384, 216, 192);
  laHA[5] = lafHA.crop(216, 384, 216, 192);
  
  laHA2 = new BufferedImage[6];
  laHA2[0] = lafHA2.crop(0, 0, 216, 192);
  laHA2[1] = lafHA2.crop(216, 0, 216, 192);
  laHA2[2] = lafHA2.crop(0, 192, 216, 192);
  laHA2[3] = lafHA2.crop(216, 192, 216, 192);
  laHA2[4] = lafHA2.crop(0, 384, 216, 192);
  laHA2[5] = lafHA2.crop(216, 384, 216, 192);
  
  laST = new BufferedImage[9];
  laST[0] = lafST.crop(0, 0, 192, 192);
  laST[1] = lafST.crop(192, 0, 192, 192);
  laST[2] = lafST.crop(384, 0, 192, 192);
  laST[3] = lafST.crop(0, 192, 192, 192);
  laST[4] = lafST.crop(192, 192, 192, 192);
  laST[5] = lafST.crop(384, 192, 192, 192);
  laST[6] = lafST.crop(0, 384, 192, 192);
  laST[7] = lafST.crop(192, 384, 192, 192);
  laST[8] = lafST.crop(384, 384, 192, 192);   
  
  laST2 = new BufferedImage[9];
  laST2[0] = lafST2.crop(0, 0, 192, 192);
  laST2[1] = lafST2.crop(192, 0, 192, 192);
  laST2[2] = lafST2.crop(384, 0, 192, 192);
  laST2[3] = lafST2.crop(0, 192, 192, 192);
  laST2[4] = lafST2.crop(192, 192, 192, 192);
  laST2[5] = lafST2.crop(384, 192, 192, 192);
  laST2[6] = lafST2.crop(0, 384, 192, 192);
  laST2[7] = lafST2.crop(192, 384, 192, 192);
  laST2[8] = lafST2.crop(384, 384, 192, 192);   
  
  laSH = new BufferedImage[5];
  laSH[0] = lafSH.crop(0, 0, 192, 288);
  laSH[1] = lafSH.crop(192, 0, 192, 288);
  laSH[2] = lafSH.crop(384, 0, 192, 288);
  laSH[3] = lafSH.crop(0, 288, 192, 288);
  laSH[4] = lafSH.crop(192, 288, 192, 288);
  
  laSH2 = new BufferedImage[5];
  laSH2[0] = lafSH2.crop(0, 0, 192, 288);
  laSH2[1] = lafSH2.crop(192, 0, 192, 288);
  laSH2[2] = lafSH2.crop(384, 0, 192, 288);
  laSH2[3] = lafSH2.crop(0, 288, 192, 288);
  laSH2[4] = lafSH2.crop(192, 288, 192, 288);
  
  shade1 = new BufferedImage[2];
  shade1[0] = laShade1.crop(0, 0, 192, 192);
  shade1[1] = laShade1.crop(0, 192, 192, 192);
  
  shade2 = new BufferedImage[2];
  shade2[0] = laShade2.crop(0, 0, 192, 192);
  shade2[1] = laShade2.crop(0, 192, 192, 192); 
  
  laC = new BufferedImage[12];
  laC[0] = lafC.crop(0, 0, 330, 192);
  laC[1] = lafC.crop(330, 0, 330, 192);
  laC[2] = lafC.crop(660, 0, 330, 192);
  laC[3] = lafC.crop(0, 192, 330, 192);
  laC[4] = lafC.crop(330, 192, 330, 192);
  laC[5] = lafC.crop(660, 192, 330, 192);
  laC[6] = lafC.crop(0, 384, 330, 192);
  laC[7] = lafC.crop(330, 384, 330, 192);
  laC[8] = lafC.crop(660, 384, 330, 192);
  laC[9] = lafC.crop(0, 576, 330, 192);
  laC[10] = lafC.crop(330, 576, 330, 192);
  laC[11] = lafC.crop(660, 576, 330, 192);
  
  laC2 = new BufferedImage[12];
  laC2[0] = lafC2.crop(0, 0, 330, 192);
  laC2[1] = lafC2.crop(330, 0, 330, 192);
  laC2[2] = lafC2.crop(660, 0, 330, 192);
  laC2[3] = lafC2.crop(0, 192, 330, 192);
  laC2[4] = lafC2.crop(330, 192, 330, 192);
  laC2[5] = lafC2.crop(660, 192, 330, 192);
  laC2[6] = lafC2.crop(0, 384, 330, 192);
  laC2[7] = lafC2.crop(330, 384, 330, 192);
  laC2[8] = lafC2.crop(660, 384, 330, 192);
  laC2[9] = lafC2.crop(0, 576, 330, 192);
  laC2[10] = lafC2.crop(330, 576, 330, 192);
  laC2[11] = lafC2.crop(660, 576, 330, 192);
  
  laUC = new BufferedImage[10];
  laUC[0] = lafUC.crop(0, 0, 192, 192);
  laUC[1] = lafUC.crop(192, 0, 192, 192);
  laUC[2] = lafUC.crop(384, 0, 192, 192);
  laUC[3] = lafUC.crop(0, 192, 192, 192);
  laUC[4] = lafUC.crop(192, 192, 192, 192);
  laUC[5] = lafUC.crop(384, 192, 192, 192);
  laUC[6] = lafUC.crop(0, 384, 192, 192);
  laUC[7] = lafUC.crop(192, 384, 192, 192);
  laUC[8] = lafUC.crop(384, 384, 192, 192);
  laUC[9] = lafUC.crop(0, 576, 192, 192);
  
  laUC2 = new BufferedImage[10];
  laUC2[0] = lafUC2.crop(0, 0, 192, 192);
  laUC2[1] = lafUC2.crop(192, 0, 192, 192);
  laUC2[2] = lafUC2.crop(384, 0, 192, 192);
  laUC2[3] = lafUC2.crop(0, 192, 192, 192);
  laUC2[4] = lafUC2.crop(192, 192, 192, 192);
  laUC2[5] = lafUC2.crop(384, 192, 192, 192);
  laUC2[6] = lafUC2.crop(0, 384, 192, 192);
  laUC2[7] = lafUC2.crop(192, 384, 192, 192);
  laUC2[8] = lafUC2.crop(384, 384, 192, 192);
  laUC2[9] = lafUC2.crop(0, 576, 192, 192);
  
  laFN = new BufferedImage[2];
  laFN[0] = la1.crop(192, 1152, 192, 192);
  laFN[1] = la1.crop(192, 1344, 192, 192);
  
  laFN2 = new BufferedImage[2];
  laFN2[0] = la1.crop(0, 1152, 192, 192);
  laFN2[1] = la1.crop(0, 1344, 192, 192);
  
  laDD = new BufferedImage[7];
  laDD[0] = lafDD.crop(0, 0, 300, 360);
  laDD[1] = lafDD.crop(300, 0, 300, 360);
  laDD[2] = lafDD.crop(600, 0, 300, 360);
  laDD[3] = lafDD.crop(0, 360, 300, 360);
  laDD[4] = lafDD.crop(300, 360, 300, 360);
  laDD[5] = lafDD.crop(600, 360, 300, 360);
  laDD[6] = lafDD.crop(0, 720, 300, 360);
  
  laDD2 = new BufferedImage[7];
  laDD2[0] = lafDD2.crop(0, 0, 300, 360);
  laDD2[1] = lafDD2.crop(300, 0, 300, 360);
  laDD2[2] = lafDD2.crop(600, 0, 300, 360);
  laDD2[3] = lafDD2.crop(0, 360, 300, 360);
  laDD2[4] = lafDD2.crop(300, 360, 300, 360);
  laDD2[5] = lafDD2.crop(600, 360, 300, 360);
  laDD2[6] = lafDD2.crop(0, 720, 300, 360);
  
  laFR = new BufferedImage[6];
  laFR[0] = lafFR.crop(0, 0, 264, 192);
  laFR[1] = lafFR.crop(264, 0, 264, 192);
  laFR[2] = lafFR.crop(0, 192, 264, 192);
  laFR[3] = lafFR.crop(264, 192, 264, 192);
  laFR[4] = lafFR.crop(0, 384, 264, 192);
  laFR[5] = lafFR.crop(264, 384, 264, 192);
  
  laFR2 = new BufferedImage[6];
  laFR2[0] = lafFR2.crop(0, 0, 264, 192);
  laFR2[1] = lafFR2.crop(264, 0, 264, 192);
  laFR2[2] = lafFR2.crop(0, 192, 264, 192);
  laFR2[3] = lafFR2.crop(264, 192, 264, 192);
  laFR2[4] = lafFR2.crop(0, 384, 264, 192);
  laFR2[5] = lafFR2.crop(264, 384, 264, 192);
  
  laAbils = new BufferedImage[6];
  laAbils[0] = lafAbils.crop(0, 0, 64, 64);
  laAbils[1] = lafAbils.crop(64, 64, 64, 64);
  laAbils[4] = lafAbils.crop(64, 0, 64, 64);
  laAbils[5] = lafAbils.crop(0, 128, 64, 64);
  laAbils[2] = lafAbils.crop(0, 64, 64, 64);   
  laAbils[3] = lafAbils.crop(64, 128, 64, 64);

  //allistar
  
  alN = new BufferedImage[2];
  alN [0] = al1.crop(960, 192, 192, 192);
  alN [1] = al1.crop(1152, 192, 192, 192);
  
  alN2 = new BufferedImage[2];
  alN2 [0] = al1.crop(0, 384, 192, 192);
  alN2 [1] = al1.crop(192, 384, 192, 192);
  
  alMR = new BufferedImage[3];
  alMR [0] = al1.crop(1152, 0, 192, 192);
  alMR [1] = al1.crop(0, 192, 192, 192);
  alMR [2] = al1.crop(192, 192, 192, 192);
  
  alML = new BufferedImage[3];
  alML [0] = al1.crop(384, 192, 192, 192);
  alML [1] = al1.crop(576, 192, 192, 192);
  alML [2] = al1.crop(768, 192, 192, 192);
  
  alMU = new BufferedImage[3];
  alMU [0] = al1.crop(0, 0, 192, 192);
  alMU [1] = al1.crop(192, 0, 192, 192);
  alMU [2] = al1.crop(384, 0, 192, 192);
  
  alMD = new BufferedImage[3];
  alMD [0] = al1.crop(576, 0, 192, 192);
  alMD [1] = al1.crop(768, 0, 192, 192);
  alMD [2] = al1.crop(960, 0, 192, 192);
  
  alLA = new BufferedImage[5];
  alLA [0] = al1.crop(384, 384, 192, 192);
  alLA [1] = al1.crop(576, 384, 192, 192);
  alLA [2] = al1.crop(768, 384, 192, 192);
  alLA [3] = al1.crop(960, 384, 192, 192);
  alLA [4] = al1.crop(1152,384, 192, 192);
  
  alLA2 = new BufferedImage[5];
  alLA2 [0] = al1.crop(0, 576, 192, 192);
  alLA2 [1] = al1.crop(192, 576, 192, 192);
  alLA2 [2] = al1.crop(384, 576, 192, 192);
  alLA2 [3] = al1.crop(576, 576, 192, 192);
  alLA2 [4] = al1.crop(768, 576, 192, 192);
  
  alHA = new BufferedImage[9];
  alHA [0] = al1.crop(960, 576, 192, 192);
  alHA [1] = al1.crop(1152, 576, 192, 192);
  alHA [2] = al1.crop(0, 768, 192, 192);
  alHA [3] = al1.crop(192, 768, 192, 192);
  alHA [4] = al1.crop(384, 768, 192, 192);
  alHA [5] = al1.crop(576, 768, 192, 192);
  alHA [6] = al1.crop(768, 768, 192, 192);
  alHA [7] = al1.crop(960, 768, 192, 192);
  alHA [8] = al1.crop(1152, 768, 192, 192);
  
  alHA2 = new BufferedImage[9];
  alHA2 [0] = al1.crop(0, 960, 192, 192);
  alHA2 [1] = al1.crop(192, 960, 192, 192);
  alHA2 [2] = al1.crop(384, 960, 192, 192);
  alHA2 [3] = al1.crop(576, 960, 192, 192);
  alHA2 [4] = al1.crop(768, 960, 192, 192);
  alHA2 [5] = al1.crop(960, 960, 192, 192);
  alHA2 [6] = al1.crop(1152, 960, 192, 192);
  alHA2 [7] = al1.crop(0, 1152, 192, 192);
  alHA2 [8] = al1.crop(192, 1152, 192, 192);  
  
  alF = new BufferedImage [3];
  alF [0] = al2.crop(576, 768, 192, 192);
  alF [1] = al2.crop(768, 768, 192, 192);
  alF [2] = al2.crop(960, 768, 192, 192);
  
  alF2 = new BufferedImage [3];
  alF2 [0] = al2.crop(1152, 768, 192, 192);
  alF2 [1] = al2.crop(0, 960, 192, 192);
  alF2 [2] = al2.crop(192, 960, 192, 192);
  
  alS = new BufferedImage [3];
  alS [0] = al2.crop(384, 960, 192, 192);
  alS [1] = al2.crop(576, 960, 192, 192);
  alS [2] = al2.crop(768, 960, 192, 192);
  
  alS2 = new BufferedImage [3];
  alS2 [0] = al2.crop(960, 960, 192, 192);
  alS2 [1] = al2.crop(1152, 960, 192, 192);
  alS2 [2] = al2.crop(0, 1152, 192, 192);
  
  alMP = new BufferedImage[6];
  alMP [0] = al2.crop(960, 1344, 192, 192);
  alMP [1] = al2.crop(1152, 1344, 192, 192);
  alMP [2] = al2.crop(0, 1536, 192, 192);
  alMP [3] = al2.crop(192, 1536, 192, 192);
  alMP [4] = al2.crop(384, 1536, 192, 192);
  alMP [5] = al2.crop(576, 1536, 192, 192);
  
  alMP2 = new BufferedImage[6];
  alMP2 [0] = al2.crop(768, 1536, 192, 192);
  alMP2 [1] = al2.crop(960, 1536, 192, 192);
  alMP2 [2] = al2.crop(1152, 1536, 192, 192);
  alMP2 [3] = al2.crop(0, 1728, 192, 192);
  alMP2 [4] = al2.crop(192, 1728, 192, 192);
  alMP2 [5] = al2.crop(384, 1728, 192, 192);
  
  alT = new BufferedImage [9];
  alT [0] = al2.crop(192, 0, 192, 192);
  alT [1] = al2.crop(384, 0, 192, 192);
  alT [2] = al2.crop(576, 0, 192, 192);
  alT [3] = al2.crop(768, 0, 192, 192);
  alT [4] = al2.crop(960, 0, 192, 192);
  alT [5] = al2.crop(1152, 0, 192, 192);
  alT [6] = al2.crop(0, 192, 192, 192);
  alT [7] = al2.crop(192, 192, 192, 192);
  alT [8] = al2.crop(384, 192, 192, 192);
  
  alT2 = new BufferedImage [9];
  alT2 [0] = al2.crop(576, 192, 192, 192);
  alT2 [1] = al2.crop(768, 192, 192, 192);
  alT2 [2] = al2.crop(960, 192, 192, 192);
  alT2 [3] = al2.crop(1152, 192, 192, 192);
  alT2 [4] = al2.crop(0, 384, 192, 192);
  alT2 [5] = al2.crop(192, 384, 192, 192);
  alT2 [6] = al2.crop(384, 384, 192, 192);
  alT2 [7] = al2.crop(576, 384, 192, 192);
  alT2 [8] = al2.crop(768, 384, 192, 192);
  
  aFlask = new BufferedImage [8];
  aFlask [0] = al2.crop(960, 384, 192, 192);
  aFlask [1] = al2.crop(1152, 384, 192, 192);
  aFlask [2] = al2.crop(0, 576, 192, 192);
  aFlask [3] = al2.crop(192, 576, 192, 192);
  aFlask [4] = al2.crop(384, 576, 192, 192);
  aFlask [5] = al2.crop(576, 576, 192, 192);
  aFlask [6] = al2.crop(768, 576, 192, 192);
  aFlask [7] = al2.crop(960, 576, 192, 192);
  
  aBreak = new BufferedImage [4];
  aBreak [0] = al2.crop(1152, 576, 192, 192);
  aBreak [1] = al2.crop(0, 768, 192, 192);
  aBreak [2] = al2.crop(192, 768, 192, 192);
  aBreak [3] = al2.crop(384, 768, 192, 192);
  
  bullet = new BufferedImage[1];
  bullet [0] = al1.crop(384, 1152, 192, 192);
  
  acid = new BufferedImage [3];
  acid [0] = effect1.crop(0, 0, 1140, 240);
  acid [1] = effect1.crop(0, 240, 1140, 240);
  acid [2] = effect1.crop(0, 480, 1140, 240);
  
  acidFire = new BufferedImage[5];
  acidFire [0] = effect2.crop(0, 0, 1140, 600);
  acidFire [1] = effect2.crop(1140, 0, 1140, 600);
  acidFire [2] = effect2.crop(0, 600, 1140, 600);
  acidFire [3] = effect2.crop(1140, 600, 1140, 600);
  acidFire [4] = effect2.crop(0, 1200, 1140, 600);
  
  alSR = new BufferedImage[14];
  alSR [0] = alRoll.crop(0, 0, 540, 192);
  alSR [1] = alRoll.crop(540, 0, 540, 192);
  alSR [2] = alRoll.crop(0, 192, 540, 192);
  alSR [3] = alRoll.crop(540, 192, 540, 192);
  alSR [4] = alRoll.crop(0, 384, 540, 192);
  alSR [5] = alRoll.crop(540, 384, 540, 192);
  alSR [6] = alRoll.crop(0, 576, 540, 192);
  alSR [7] = alRoll.crop(540, 576, 540, 192);
  alSR [8] = alRoll.crop(0, 768, 540, 192);
  alSR [9] = alRoll.crop(540, 768, 540, 192);
  alSR [10] = alRoll.crop(0, 960, 540, 192);
  alSR [11] = alRoll.crop(540, 960, 540, 192);
  alSR [12] = alRoll.crop(0, 1152, 540, 192);
  alSR [13] = alRoll.crop(540, 1152, 540, 192);
  
  alSR2 = new BufferedImage[14];
  alSR2 [0] = alRoll2.crop(0, 0, 540, 192);
  alSR2 [1] = alRoll2.crop(540, 0, 540, 192);
  alSR2 [2] = alRoll2.crop(0, 192, 540, 192);
  alSR2 [3] = alRoll2.crop(540, 192, 540, 192);
  alSR2 [4] = alRoll2.crop(0, 384, 540, 192);
  alSR2 [5] = alRoll2.crop(540, 384, 540, 192);
  alSR2 [6] = alRoll2.crop(0, 576, 540, 192);
  alSR2 [7] = alRoll2.crop(540, 576, 540, 192);
  alSR2 [8] = alRoll2.crop(0, 768, 540, 192);
  alSR2 [9] = alRoll2.crop(540, 768, 540, 192);
  alSR2 [10] = alRoll2.crop(0, 960, 540, 192);
  alSR2 [11] = alRoll2.crop(540, 960, 540, 192);
  alSR2 [12] = alRoll2.crop(0, 1152, 540, 192);
  alSR2 [13] = alRoll2.crop(540, 1152, 540, 192);
  
  mineIdle = new BufferedImage[2];
  mineIdle [0] = al2.crop(192, 1152, 192, 192);
  mineIdle [1] = al2.crop(384, 1152, 192, 192);
  
  mineTrig = new BufferedImage[10];
  mineTrig [0] = al2.crop(384, 1152, 192, 192);
  mineTrig [1] = al2.crop(576, 1152, 192, 192);
  mineTrig [2] = al2.crop(768, 1152, 192, 192);
  mineTrig [3] = al2.crop(960, 1152, 192, 192);
  mineTrig [4] = al2.crop(1152, 1152, 192, 192);
  mineTrig [5] = al2.crop(0, 1344, 192, 192);
  mineTrig [6] = al2.crop(192, 1344, 192, 192);
  mineTrig [7] = al2.crop(384, 1344, 192, 192);
  mineTrig [8] = al2.crop(576, 1344, 192, 192);
  mineTrig [9] = al2.crop(768, 1344, 192, 192);
  
  alAbils = new BufferedImage[6];
  alAbils[0] = allAbils.crop(0, 0, 64, 64);
  alAbils[1] = allAbils.crop(64, 64, 64, 64);
  alAbils[4] = allAbils.crop(64, 0, 64, 64);
  alAbils[5] = allAbils.crop(0, 128, 64, 64);
  alAbils[2] = allAbils.crop(0, 64, 64, 64);   
  alAbils[3] = allAbils.crop(64, 128, 64, 64);
  
  }

}