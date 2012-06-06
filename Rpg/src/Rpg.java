import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JApplet;
import java.awt.Shape;
import java.awt.image.*;

public class Rpg extends JApplet implements MouseListener 
{
	public String strengthText;
	public int enemyState;
	public int[] RectDim;
	public double health;
	public double gageTempHealth;
	public int tempExperience;
	public double ExpTNL;
	public int level;
	public int strength;
	public int tempStrength;
	public int defense;
	public int tokens;
	public double experience;
	public boolean turn;
	public boolean levelUp;
	public int mana;
	public int tempZone;
	public boolean Gain;
	public int tempMana1;
	public boolean heal;
	public double healHealth;
	public int zone;
	public int moveState;
	public int manaRegen;
	public int tokensGiven;
	public boolean noMana;
	public boolean training;
	public boolean nextBattle;
	public boolean bossBattle;
	public boolean noTokens;
	public int trainingEnemy;	
	public int tempManaRegen1;
	public int tempStrength1;
	public int tempHealth1;
	public boolean manaAdd;
	public int enemyTempDamage;
	public int nextBattleEnemy;
	public int bossBattleEnemy;
	public int tempMana;
	public boolean bossZone;
	public int bossZoneReq;
	public int enemyTokens;
	public int enemyExperience;
	public int damage;
	public int stage;
	public int x1;
	public int y1;
	public int xLength;
	public int yLength;
	public int buyItem;
	public boolean runTry;
	public boolean ran;
	public String enemyName;
	public double enemyHealth;
	public double enemyTempHealth;
	public int enemyStrength;
	public int enemyDefense;
	public int tempDamage;
	public int BossTokens;
	public int GameState;
	public int tokensLost;
	public String gain;
	public int color;
	public boolean manaRegenGain;
	public boolean healthGain;
	public boolean manaGain;
	public boolean strengthGain;
	private int optionHeight;
	private int optionWidth;
	private int optionLeft;
	private int optionRight;
	public boolean lv50;
	public int zoneReq;
	public boolean notZone;
	public boolean manaBurst;
	public boolean save;
	public boolean start;
	public boolean mouseExit;
	public int tempState;
	int j;
	public String Title;
	public boolean back;
	Random r= new Random();


	File gage= new File("RpgSave.txt");

	Font MenuText=new Font("Menu",Font.BOLD,40);
	Font TitleText=new Font("Title",Font.BOLD,40);
	Font BattleText=new Font("Battle",Font.BOLD,15);
	Font StartText=new Font("Start",Font.ITALIC,30);
	Font OptionText=new Font("Option",Font.ITALIC,25);
	Font MoveText=new Font("Moves",Font.ROMAN_BASELINE,15);
	Font SaveText=new Font("Save",Font.ITALIC,70);

	public void createRpgFile() throws IOException
	{			
		if(!gage.exists())
		{
			gage.createNewFile();
			String path = gage.getAbsolutePath();
			PrintWriter outside = new PrintWriter(new BufferedWriter(new FileWriter(path)));
			outside.println("40");//health
			outside.println("1");//level
			outside.println("1000");//mana
			outside.println("3");//Strength
			outside.println("0");//Defense
			outside.println("1");//nextBattleEnemy
			outside.println("1");//zone
			outside.println("1");//tempZone
			outside.println("0");//tokens
			outside.println("0");//exp
			outside.println("5");//mana regen
			outside.close();

			BufferedReader g = new BufferedReader(new FileReader(gage.getAbsolutePath()));
			health=Double.parseDouble(g.readLine());
			level=Integer.parseInt(g.readLine());
			mana=Integer.parseInt(g.readLine());
			strength=Integer.parseInt(g.readLine());
			defense=Integer.parseInt(g.readLine());
			nextBattleEnemy=Integer.parseInt(g.readLine());
			zone=Integer.parseInt(g.readLine());
			tempZone=Integer.parseInt(g.readLine());
			tokens=Integer.parseInt(g.readLine());
			experience=Double.parseDouble(g.readLine());
			manaRegen=Integer.parseInt(g.readLine());
			g.close();
		}
		if(gage.exists())
		{
			BufferedReader g = new BufferedReader(new FileReader(gage.getAbsolutePath()));
			health=Double.parseDouble(g.readLine());
			level=Integer.parseInt(g.readLine());
			mana=Integer.parseInt(g.readLine());
			strength=Integer.parseInt(g.readLine());
			defense=Integer.parseInt(g.readLine());
			nextBattleEnemy=Integer.parseInt(g.readLine());
			zone=Integer.parseInt(g.readLine());
			tempZone=Integer.parseInt(g.readLine());
			tokens=Integer.parseInt(g.readLine());
			experience=Double.parseDouble(g.readLine());
			manaRegen=Integer.parseInt(g.readLine());
			g.close();
		}	





	}

	public void save() throws IOException
	{
		PrintWriter outside = new PrintWriter(new BufferedWriter(new FileWriter(gage.getAbsolutePath())));
		outside.println(health);
		outside.println(level);
		outside.println(mana);
		outside.println(strength);
		outside.println(defense);
		outside.println(nextBattleEnemy);
		outside.println(zone);
		outside.println(tempZone);
		outside.println(tokens);
		outside.println(experience);
		outside.println(manaRegen);
		outside.close();
	}

	public void init()
	{	
		Title="Gage v1.9 Beta";
		RectDim= new int[4];
		try {
			createRpgFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		optionHeight=70;
		optionWidth=130;
		optionLeft=60;
		optionRight=400;
		setSize(610, 510);
		addMouseListener(this);
	}

	public void enemyStats()
	{
		RectDim[0]=100;
		RectDim[1]=200;
		tempMana=mana;
		gageTempHealth=health;
		if(training==true)
		{

			if(trainingEnemy==1)
			{
				enemyName="Very Tiny Red Square";
				enemyHealth=10;
				enemyStrength=3;
				enemyDefense=0;
				enemyExperience=1;
				enemyTokens=2;
				RectDim[2]=20;
				RectDim[3]=20;
				color=1;
				enemyState=0;
			}
			else if(trainingEnemy==2)
			{
				enemyName="Very Tiny Orange Square";
				enemyHealth=30;
				enemyStrength=7;
				enemyDefense=1;
				enemyExperience=5;
				enemyTokens=3;
				RectDim[2]=20;
				RectDim[3]=20;
				color=2;
				enemyState=0;
			}
			else if(trainingEnemy==3)
			{
				enemyName="Very Tiny Yellow Square";
				enemyHealth=100;
				enemyStrength=10;
				enemyDefense=2;
				enemyExperience=8;
				enemyTokens=4;
				RectDim[2]=20;
				RectDim[3]=20;
				color=3;
				enemyState=0;
			}
			else if(trainingEnemy==4)
			{
				enemyName="Very Tiny Green Square";
				enemyHealth=200;
				enemyStrength=15;
				enemyDefense=3;
				enemyExperience=10;
				enemyTokens=5;
				RectDim[2]=20;
				RectDim[3]=20;
				color=4;
				enemyState=0;
			}
			else if(trainingEnemy==5)
			{
				enemyName="Very Tiny Cyan Square";
				enemyHealth=300;
				enemyStrength=20;
				enemyDefense=4;
				enemyExperience=12;
				enemyTokens=6;
				RectDim[2]=20;
				RectDim[3]=20;
				color=5;
				enemyState=0;
			}
			else if(trainingEnemy==6)
			{
				enemyName="Very Tiny Blue Square";
				enemyHealth=1000;
				enemyStrength=30;
				enemyDefense=5;
				enemyExperience=15;
				enemyTokens=7;
				RectDim[2]=20;
				RectDim[3]=20;
				color=6;
				enemyState=0;
			}
			else if(trainingEnemy==7)
			{
				enemyName="Very Tiny White Square";
				enemyHealth=1600;
				enemyStrength=40;
				enemyDefense=7;
				enemyExperience=20;
				enemyTokens=8;
				RectDim[2]=20;
				RectDim[3]=20;
				color=7;
				enemyState=0;
			}
			else if(trainingEnemy==8)
			{
				enemyName="Very Tiny Black Square";
				enemyHealth=500;
				enemyStrength=50;
				enemyDefense=10;
				enemyExperience=80;
				enemyTokens=9;
				RectDim[2]=20;
				RectDim[3]=20;
				color=8;
				enemyState=0;
			}

		}

		if(nextBattle==true)
		{

			if(nextBattleEnemy==1)
			{
				enemyHealth=10;
				enemyStrength=1;
				enemyDefense=0;
				enemyExperience=1;
				enemyTokens=2;
				RectDim[2]=25;
				RectDim[3]=25;
				color=1;
				enemyState=0;
			}
			else if(nextBattleEnemy==2)
			{
				enemyHealth=15;
				enemyStrength=1;
				enemyDefense=0;
				enemyExperience=1;
				enemyTokens=2;
				RectDim[2]=30;
				RectDim[3]=30;
				color=1;
				enemyState=0;
			}
			else if(nextBattleEnemy==3)
			{
				enemyHealth=20;
				enemyStrength=1;
				enemyDefense=0;
				enemyExperience=2;
				enemyTokens=2;
				RectDim[2]=35;
				RectDim[3]=35;
				color=1;
				enemyState=0;
			}
			else if(nextBattleEnemy==4)
			{
				enemyHealth=20;
				enemyStrength=2;
				enemyDefense=0;
				enemyExperience=2;
				enemyTokens=2;
				RectDim[2]=40;
				RectDim[3]=40;
				color=1;
				enemyState=0;
			}
			else if(nextBattleEnemy==5)
			{
				enemyHealth=20;
				enemyStrength=2;
				enemyDefense=0;
				enemyExperience=2;
				enemyTokens=2;
				RectDim[2]=50;
				RectDim[3]=50;
				color=1;
				enemyState=0;
			}
			else if(nextBattleEnemy==6)
			{
				enemyHealth=25;
				enemyStrength=2;
				enemyDefense=0;
				enemyExperience=3;
				enemyTokens=2;
				RectDim[2]=60;
				RectDim[3]=60;
				color=1;
				enemyState=0;
			}
			else if(nextBattleEnemy==7)
			{
				enemyHealth=25;
				enemyStrength=3;
				enemyDefense=0;
				enemyExperience=3;
				enemyTokens=2;
				RectDim[2]=70;
				RectDim[3]=70;
				color=1;
				enemyState=0;
			}
			else if(nextBattleEnemy==8)
			{
				enemyHealth=30;
				enemyStrength=3;
				enemyDefense=0;
				enemyExperience=3;
				enemyTokens=2;
				RectDim[2]=90;
				RectDim[3]=90;
				color=1;
				enemyState=0;
			}
			else if(nextBattleEnemy==9)
			{
				enemyHealth=35;
				enemyStrength=3;
				enemyDefense=0;
				enemyExperience=4;
				enemyTokens=2;
				RectDim[2]=100;
				RectDim[3]=100;
				color=1;
				enemyState=0;
			}
			else if(nextBattleEnemy==10)
			{
				enemyHealth=40;
				enemyStrength=4;
				enemyDefense=0;
				enemyExperience=4;
				enemyTokens=2;
				RectDim[2]=50;
				RectDim[3]=50;
				color=1;
				enemyState=1;
			}
			else if(nextBattleEnemy==11)
			{
				enemyHealth=40;
				enemyStrength=4;
				enemyDefense=1;
				enemyExperience=4;
				enemyTokens=3;
				RectDim[2]=25;
				RectDim[3]=25;
				color=2;
				enemyState=0;

			}
			else if(nextBattleEnemy==12)
			{
				enemyHealth=45;
				enemyStrength=5;
				enemyDefense=1;
				enemyExperience=5;
				enemyTokens=3;
				RectDim[2]=30;
				RectDim[3]=30;
				color=2;
				enemyState=0;
			}
			else if(nextBattleEnemy==13)
			{
				enemyHealth=50;
				enemyStrength=5;
				enemyDefense=1;
				enemyExperience=5;
				enemyTokens=3;
				RectDim[2]=35;
				RectDim[3]=35;
				color=2;
				enemyState=0;
			}
			else if(nextBattleEnemy==14)
			{
				enemyHealth=55;
				enemyStrength=5;
				enemyDefense=1;
				enemyExperience=5;
				enemyTokens=3;
				RectDim[2]=40;
				RectDim[3]=40;
				color=2;
				enemyState=0;

			}
			else if(nextBattleEnemy==15)
			{
				enemyHealth=60;
				enemyStrength=6;
				enemyDefense=1;
				enemyExperience=6;
				enemyTokens=3;
				RectDim[2]=50;
				RectDim[3]=50;
				color=2;
				enemyState=0;
			}
			else if(nextBattleEnemy==16)
			{
				enemyHealth=70;
				enemyStrength=6;
				enemyDefense=1;
				enemyExperience=6;
				enemyTokens=3;
				RectDim[2]=60;
				RectDim[3]=60;
				color=2;
				enemyState=0;
			}
			else if(nextBattleEnemy==17)
			{
				enemyHealth=80;
				enemyStrength=6;
				enemyDefense=1;
				enemyExperience=6;
				enemyTokens=3;
				RectDim[2]=80;
				RectDim[3]=80;
				color=2;
				enemyState=0;
			}
			else if(nextBattleEnemy==18)
			{
				enemyHealth=85;
				enemyStrength=7;
				enemyDefense=1;
				enemyExperience=7;
				enemyTokens=3;
				RectDim[2]=90;
				RectDim[3]=90;
				color=2;
				enemyState=0;
			}
			else if(nextBattleEnemy==19)
			{
				enemyHealth=90;
				enemyStrength=7;
				enemyDefense=1;
				enemyExperience=7;
				enemyTokens=3;
				RectDim[2]=100;
				RectDim[3]=100;
				color=2;
				enemyState=0;
			}
			else if(nextBattleEnemy==20)
			{
				enemyHealth=100;
				enemyStrength=8;
				enemyDefense=1;
				enemyExperience=8;
				enemyTokens=3;
				RectDim[2]=50;
				RectDim[3]=50;
				color=2;
				enemyState=1;
			}
			else if(nextBattleEnemy==21)
			{
				enemyHealth=100;
				enemyStrength=8;
				enemyDefense=2;
				enemyExperience=8;
				enemyTokens=4;
				RectDim[2]=25;
				RectDim[3]=25;
				color=3;
				enemyState=0;
			}
			else if(nextBattleEnemy==22)
			{
				enemyHealth=110;
				enemyStrength=8;
				enemyDefense=2;
				enemyExperience=8;
				enemyTokens=4;
				RectDim[2]=30;
				RectDim[3]=30;
				color=3;
				enemyState=0;
			}
			else if(nextBattleEnemy==23)
			{
				enemyHealth=120;
				enemyStrength=9;
				enemyDefense=2;
				enemyExperience=8;
				enemyTokens=4;
				RectDim[2]=35;
				RectDim[3]=35;
				color=3;
				enemyState=0;
			}
			else if(nextBattleEnemy==24)
			{
				enemyHealth=130;
				enemyStrength=9;
				enemyDefense=2;
				enemyExperience=9;
				enemyTokens=4;
				RectDim[2]=40;
				RectDim[3]=40;
				color=3;
				enemyState=0;
			}
			else if(nextBattleEnemy==25)
			{
				enemyHealth=140;
				enemyStrength=9;
				enemyDefense=2;
				enemyExperience=9;
				enemyTokens=4;
				RectDim[2]=50;
				RectDim[3]=50;
				color=3;
				enemyState=0;
			}
			else if(nextBattleEnemy==26)
			{
				enemyHealth=150;
				enemyStrength=10;
				enemyDefense=2;
				enemyExperience=9;
				enemyTokens=4;
				RectDim[2]=60;
				RectDim[3]=60;
				color=3;
				enemyState=0;
			}
			else if(nextBattleEnemy==27)
			{
				enemyHealth=160;
				enemyStrength=10;
				enemyDefense=2;
				enemyExperience=9;
				enemyTokens=4;
				RectDim[2]=70;
				RectDim[3]=70;
				color=3;
				enemyState=0;
			}
			else if(nextBattleEnemy==28)
			{
				enemyHealth=170;
				enemyStrength=11;
				enemyDefense=2;
				enemyExperience=9;
				enemyTokens=4;
				RectDim[2]=90;
				RectDim[3]=90;
				color=3;
				enemyState=0;
			}
			else if(nextBattleEnemy==29)
			{
				enemyHealth=185;
				enemyStrength=11;
				enemyDefense=2;
				enemyExperience=9;
				enemyTokens=4;
				RectDim[2]=100;
				RectDim[3]=100;
				color=3;
				enemyState=0;
			}
			else if(nextBattleEnemy==30)
			{
				enemyHealth=200;
				enemyStrength=12;
				enemyDefense=2;
				enemyExperience=10;
				enemyTokens=4;
				RectDim[2]=50;
				RectDim[3]=50;
				color=3;
				enemyState=1;
			}
			else if(nextBattleEnemy==31)
			{
				enemyHealth=210;
				enemyStrength=13;
				enemyDefense=3;
				enemyExperience=10;
				enemyTokens=5;
				RectDim[2]=25;
				RectDim[3]=25;
				color=4;
				enemyState=0;
			}
			else if(nextBattleEnemy==32)
			{
				enemyHealth=220;
				enemyStrength=13;
				enemyDefense=3;
				enemyExperience=11;
				enemyTokens=5;
				RectDim[2]=30;
				RectDim[3]=30;
				color=4;
				enemyState=0;
			}
			else if(nextBattleEnemy==33)
			{
				enemyHealth=220;
				enemyStrength=13;
				enemyDefense=3;
				enemyExperience=11;
				enemyTokens=5;
				RectDim[2]=35;
				RectDim[3]=35;
				color=4;
				enemyState=0;
			}
			else if(nextBattleEnemy==34)
			{
				enemyHealth=230;
				enemyStrength=14;
				enemyDefense=3;
				enemyExperience=11;
				enemyTokens=5;
				RectDim[2]=40;
				RectDim[3]=40;
				color=4;
				enemyState=0;
			}
			else if(nextBattleEnemy==35)
			{
				enemyHealth=250;
				enemyStrength=15;
				enemyDefense=3;
				enemyExperience=11;
				enemyTokens=5;
				RectDim[2]=50;
				RectDim[3]=50;
				color=4;
				enemyState=0;
			}
			else if(nextBattleEnemy==36)
			{
				enemyHealth=270;
				enemyStrength=16;
				enemyDefense=3;
				enemyExperience=12;
				enemyTokens=5;
				RectDim[2]=60;
				RectDim[3]=60;
				color=4;
				enemyState=0;
			}
			else if(nextBattleEnemy==37)
			{
				enemyHealth=300;
				enemyStrength=16;
				enemyDefense=3;
				enemyExperience=11;
				enemyTokens=5;
				RectDim[2]=70;
				RectDim[3]=70;
				color=4;
				enemyState=0;
			}
			else if(nextBattleEnemy==38)
			{
				enemyHealth=350;
				enemyStrength=17;
				enemyDefense=3;
				enemyExperience=12;
				enemyTokens=5;
				RectDim[2]=90;
				RectDim[3]=90;
				color=4;
				enemyState=0;
			}
			else if(nextBattleEnemy==39)
			{
				enemyHealth=400;
				enemyStrength=18;
				enemyDefense=3;
				enemyExperience=12;
				enemyTokens=5;
				RectDim[2]=100;
				RectDim[3]=100;
				color=4;
				enemyState=0;
			}
			else if(nextBattleEnemy==40)
			{
				enemyHealth=450;
				enemyStrength=18;
				enemyDefense=3;
				enemyExperience=12;
				enemyTokens=5;
				RectDim[2]=50;
				RectDim[3]=50;
				color=4;
				enemyState=1;
			}
			else if(nextBattleEnemy==41)
			{
				enemyHealth=500;
				enemyStrength=19;
				enemyDefense=4;
				enemyExperience=13;
				enemyTokens=6;
				RectDim[2]=25;
				RectDim[3]=25;
				color=5;
				enemyState=0;
			}
			else if(nextBattleEnemy==42)
			{
				enemyHealth=550;
				enemyStrength=20;
				enemyDefense=4;
				enemyExperience=13;
				enemyTokens=6;
				RectDim[2]=30;
				RectDim[3]=30;
				color=5;
				enemyState=0;
			}
			else if(nextBattleEnemy==43)
			{
				enemyHealth=600;
				enemyStrength=21;
				enemyDefense=4;
				enemyExperience=13;
				enemyTokens=6;
				RectDim[2]=35;
				RectDim[3]=35;
				color=5;
				enemyState=0;
			}
			else if(nextBattleEnemy==44)
			{
				enemyHealth=650;
				enemyStrength=22;
				enemyDefense=4;
				enemyExperience=13;
				enemyTokens=6;
				RectDim[2]=40;
				RectDim[3]=40;
				color=5;
				enemyState=0;
			}
			else if(nextBattleEnemy==45)
			{
				enemyHealth=700;
				enemyStrength=23;
				enemyDefense=4;
				enemyExperience=13;
				enemyTokens=6;
				RectDim[2]=50;
				RectDim[3]=50;
				color=4;
				enemyState=0;
			}
			else if(nextBattleEnemy==46)
			{
				enemyHealth=750;
				enemyStrength=24;
				enemyDefense=4;
				enemyExperience=13;
				enemyTokens=5;
				RectDim[2]=60;
				RectDim[3]=60;
				color=5;
				enemyState=0;
			}
			else if(nextBattleEnemy==47)
			{
				enemyHealth=800;
				enemyStrength=25;
				enemyDefense=4;
				enemyExperience=13;
				enemyTokens=5;
				RectDim[2]=70;
				RectDim[3]=70;
				color=5;
				enemyState=0;
			}
			else if(nextBattleEnemy==48)
			{
				enemyHealth=850;
				enemyStrength=26;
				enemyDefense=4;
				enemyExperience=13;
				enemyTokens=5;
				RectDim[2]=90;
				RectDim[3]=90;
				color=5;
				enemyState=0;
			}
			else if(nextBattleEnemy==49)
			{
				enemyHealth=900;
				enemyStrength=27;
				enemyDefense=4;
				enemyExperience=13;
				enemyTokens=5;
				RectDim[2]=100;
				RectDim[3]=100;
				color=5;
				enemyState=0;
			}
			else if(nextBattleEnemy==50)
			{
				enemyHealth=1000;
				enemyStrength=28;
				enemyDefense=5;
				enemyExperience=13;
				enemyTokens=5;
				RectDim[2]=50;
				RectDim[3]=50;
				color=5;
				enemyState=1;
			}
			else if(nextBattleEnemy==51)
			{
				enemyHealth=1050;
				enemyStrength=28;
				enemyDefense=5;
				enemyExperience=14;
				enemyTokens=6;
				RectDim[2]=25;
				RectDim[3]=25;
				color=6;
				enemyState=0;
			}
			else if(nextBattleEnemy==52)
			{
				enemyHealth=1100;
				enemyStrength=28;
				enemyDefense=5;
				enemyExperience=14;
				enemyTokens=6;
				RectDim[2]=30;
				RectDim[3]=30;
				color=6;
				enemyState=0;
			}
			else if(nextBattleEnemy==53)
			{
				enemyHealth=1200;
				enemyStrength=29;
				enemyDefense=5;
				enemyExperience=14;
				enemyTokens=6;
				RectDim[2]=35;
				RectDim[3]=35;
				color=6;
				enemyState=0;
			}
			else if(nextBattleEnemy==54)
			{
				enemyHealth=1250;
				enemyStrength=30;
				enemyDefense=5;
				enemyExperience=14;
				enemyTokens=6;
				RectDim[2]=40;
				RectDim[3]=40;
				color=6;
				enemyState=0;
			}
			else if(nextBattleEnemy==55)
			{
				enemyHealth=1300;
				enemyStrength=30;
				enemyDefense=5;
				enemyExperience=14;
				enemyTokens=6;
				RectDim[2]=50;
				RectDim[3]=50;
				color=6;
				enemyState=0;
			}
			else if(nextBattleEnemy==56)
			{
				enemyHealth=1350;
				enemyStrength=31;
				enemyDefense=5;
				enemyExperience=14;
				enemyTokens=6;
				RectDim[2]=60;
				RectDim[3]=60;
				color=6;
				enemyState=0;
			}
			else if(nextBattleEnemy==57)
			{
				enemyHealth=1400;
				enemyStrength=32;
				enemyDefense=5;
				enemyExperience=14;
				enemyTokens=6;
				RectDim[2]=70;
				RectDim[3]=70;
				color=6;
				enemyState=0;
			}
			else if(nextBattleEnemy==58)
			{
				enemyHealth=1450;
				enemyStrength=33;
				enemyDefense=5;
				enemyExperience=14;
				enemyTokens=6;
				RectDim[2]=90;
				RectDim[3]=90;
				color=6;
				enemyState=0;
			}
			else if(nextBattleEnemy==59)
			{
				enemyHealth=1500;
				enemyStrength=33;
				enemyDefense=5;
				enemyExperience=14;
				enemyTokens=6;
				RectDim[2]=100;
				RectDim[3]=100;
				color=6;
				enemyState=0;
			}
			else if(nextBattleEnemy==60)
			{
				enemyHealth=1600;
				enemyStrength=33;
				enemyDefense=5;
				enemyExperience=14;
				enemyTokens=6;
				RectDim[2]=50;
				RectDim[3]=50;
				color=6;
				enemyState=1;
			}
			else if(nextBattleEnemy==61)
			{
				enemyHealth=1600;
				enemyStrength=34;
				enemyDefense=6;
				enemyExperience=15;
				enemyTokens=7;
				RectDim[2]=25;
				RectDim[3]=25;
				color=7;
				enemyState=0;
			}
			else if(nextBattleEnemy==62)
			{
				enemyHealth=1650;
				enemyStrength=34;
				enemyDefense=6;
				enemyExperience=15;
				enemyTokens=7;
				RectDim[2]=30;
				RectDim[3]=30;
				color=7;
				enemyState=0;
			}
			else if(nextBattleEnemy==63)
			{
				enemyHealth=1700;
				enemyStrength=35;
				enemyDefense=6;
				enemyExperience=15;
				enemyTokens=7;
				RectDim[2]=35;
				RectDim[3]=35;
				color=7;
				enemyState=0;
			}
			else if(nextBattleEnemy==64)
			{
				enemyHealth=1750;
				enemyStrength=35;
				enemyDefense=6;
				enemyExperience=15;
				enemyTokens=7;
				RectDim[2]=40;
				RectDim[3]=40;
				color=7;
				enemyState=0;
			}
			else if(nextBattleEnemy==65)
			{
				enemyHealth=1800;
				enemyStrength=36;
				enemyDefense=6;
				enemyExperience=15;
				enemyTokens=7;
				RectDim[2]=50;
				RectDim[3]=50;
				color=7;
				enemyState=0;
			}
			else if(nextBattleEnemy==66)
			{
				enemyHealth=1850;
				enemyStrength=37;
				enemyDefense=6;
				enemyExperience=15;
				enemyTokens=7;
				RectDim[2]=60;
				RectDim[3]=60;
				color=7;
				enemyState=0;
			}
			else if(nextBattleEnemy==67)
			{
				enemyHealth=1900;
				enemyStrength=37;
				enemyDefense=6;
				enemyExperience=15;
				enemyTokens=7;
				RectDim[2]=70;
				RectDim[3]=70;
				color=7;
				enemyState=0;
			}
			else if(nextBattleEnemy==68)
			{
				enemyHealth=1950;
				enemyStrength=38;
				enemyDefense=6;
				enemyExperience=15;
				enemyTokens=7;
				RectDim[2]=90;
				RectDim[3]=90;
				color=7;
				enemyState=0;
			}
			else if(nextBattleEnemy==69)
			{
				enemyHealth=2000;
				enemyStrength=39;
				enemyDefense=6;
				enemyExperience=15;
				enemyTokens=7;
				RectDim[2]=100;
				RectDim[3]=100;
				color=7;
				enemyState=0;
			}
			else if(nextBattleEnemy==70)
			{
				enemyHealth=2000;
				enemyStrength=40;
				enemyDefense=6;
				enemyExperience=15;
				enemyTokens=7;
				RectDim[2]=50;
				RectDim[3]=50;
				color=7;
				enemyState=1;
			}
		}

		if(bossBattle==true)
		{
			if(bossBattleEnemy==1)
			{
				enemyName="Massive Red Circle";
				enemyHealth=50;
				enemyStrength=5;
				enemyDefense=1;
				enemyExperience=5;
				enemyTokens=2;
				RectDim[2]=100;
				RectDim[3]=100;
				color=1;
				enemyState=1;
			}
			else if(bossBattleEnemy==2)
			{
				enemyName="Massive Orange Circle";
				enemyHealth=150;
				enemyStrength=10;
				enemyDefense=2;
				enemyExperience=8;
				enemyTokens=3;
				RectDim[2]=100;
				RectDim[3]=100;
				color=2;
				enemyState=1;
			}
			else if(bossBattleEnemy==3)
			{
				enemyName="Massive Yellow Circle";
				enemyHealth=400;
				enemyStrength=15;
				enemyDefense=3;
				enemyExperience=10;
				enemyTokens=4;
				RectDim[2]=100;
				RectDim[3]=100;
				color=3;
				enemyState=1;
			}
			else if(bossBattleEnemy==4)
			{
				enemyName="Massive Green Circle";
				enemyHealth=600;
				enemyStrength=20;
				enemyDefense=4;
				enemyExperience=12;
				enemyTokens=5;
				RectDim[2]=100;
				RectDim[3]=100;
				color=3;
				enemyState=1;
			}
			else if(bossBattleEnemy==5)
			{
				enemyName="Massive Cyan Circle";
				enemyHealth=800;
				enemyStrength=25;
				enemyDefense=5;
				enemyExperience=15;
				enemyTokens=6;
				RectDim[2]=100;
				RectDim[3]=100;
				color=3;
				enemyState=1;
			}
			else if(bossBattleEnemy==6)
			{
				enemyName="Massive Blue Circle";
				enemyHealth=400;
				enemyStrength=30;
				enemyDefense=6;
				enemyExperience=15;
				enemyTokens=7;
				RectDim[2]=100;
				RectDim[3]=100;
				color=3;
				enemyState=1;
			}
			else if(bossBattleEnemy==7)
			{
				enemyName="Massive White Circle";
				enemyHealth=2000;
				enemyStrength=35;
				enemyDefense=7;
				enemyExperience=15;
				enemyTokens=8;
				RectDim[2]=100;
				RectDim[3]=100;
				color=3;
				enemyState=1;
			}
		}
	}

	public void paint(Graphics page)
	{
		page.setFont(MoveText);
		Polygon p=new Polygon();
		p.addPoint(310,240);
		p.addPoint(250,300);
		p.addPoint(370,300);
		if(back==false)
		{
			page.clearRect(0,0,700,600);
		}
		page.drawRect(0,0,600,500);
		page.drawString(Title,10,490);
		if(GameState==0)
		{
			page.drawRect(200,100,150,80);
			page.drawRect(200,300,150,80);
			page.setFont(TitleText);
			page.drawString(Title,120,50);
			page.setFont(StartText);
			page.drawString("Start",240,150);
			page.drawString("Quit",240,350);
		}
		//Main Menu//
		else if(GameState==1)
		{
			nextBattle=false;
			training=false;
			bossBattle=false;
			page.setFont(MenuText);
			page.drawString("MENU",230,50);
			page.setFont(OptionText);
			page.setColor(Color.yellow);
			page.drawString("Training", optionLeft+10, 115);
			page.setColor(Color.red);
			page.drawString("Next Battle",optionLeft+3,215);
			page.setColor(Color.blue);
			page.drawString("Boss Battle", optionLeft+1, 315);
			page.setColor(Color.magenta);
			page.drawString("Zones", optionLeft+15, 415);
			page.setColor(Color.green);
			page.drawString("Shop", optionRight+40, 115);
			page.setColor(Color.cyan);
			page.drawString("Extra", optionRight+30, 215);
			page.setColor(Color.pink);
			page.drawString("Save", optionRight+30, 315);
			page.setColor(Color.red);
			page.drawString("Quit", optionRight+30, 415);
			page.setColor(Color.black);
			page.drawRect(optionLeft,75,optionWidth,optionHeight);
			page.drawRect(optionLeft,175,optionWidth,optionHeight);
			page.drawRect(optionLeft,275,optionWidth,optionHeight);
			page.drawRect(optionLeft,375,optionWidth,optionHeight);
			page.drawRect(optionRight,75,optionWidth,optionHeight);
			page.drawRect(optionRight,175,optionWidth,optionHeight);
			page.drawRect(optionRight,275,optionWidth,optionHeight);
			page.drawRect(optionRight,375,optionWidth,optionHeight);

		}
		//Training Selection Screen(will go to gameState 3)//
		else if(GameState==2)
		{
			page.setFont(MenuText);
			page.drawString("TRAINING",200,50);
			page.setFont(OptionText);
			page.drawString("lv 1-10",optionLeft+15,115);
			page.drawString("lv 11-20",optionLeft+15,215);
			page.drawString("lv 21-30",optionLeft+15,315);
			page.drawString("lv 31-40",optionLeft+15,415);
			page.drawString("lv 41-50",optionRight+15,115);
			page.drawString("lv 51-65",optionRight+15,215);
			page.drawString("lv 66-80",optionRight+15,315);
			page.drawString("Back",optionRight+30,415);
			page.drawRect(optionLeft,75,optionWidth,optionHeight);
			page.drawRect(optionLeft,175,optionWidth,optionHeight);
			page.drawRect(optionLeft,275,optionWidth,optionHeight);
			page.drawRect(optionLeft,375,optionWidth,optionHeight);
			page.drawRect(optionRight,75,optionWidth,optionHeight);
			page.drawRect(optionRight,175,optionWidth,optionHeight);
			page.drawRect(optionRight,275,optionWidth,optionHeight);
			page.drawRect(optionRight,375,optionWidth,optionHeight);
		}
		//Battle Sequence//
		else if(GameState==3)
		{
			if(damage==0&&start==false)
			{
				page.setColor(Color.blue);
				page.drawRoundRect(100,300,20,20, 10, 10);
				page.drawLine(100,320,110,330);
				page.drawLine(120,320,110,330);
				page.drawLine(110,300,110,320);
				page.drawLine(100,310,120,310);
				page.draw3DRect(100,300,20,20,true);
				page.setFont(OptionText);
				page.drawString("BLOCKED",100,350);
			}

			if(enemyTempDamage==0&&start==false)
			{
				page.setColor(Color.blue);
				page.drawRoundRect(400,310,20,20, 10, 10);
				page.drawLine(400,330,410,340);
				page.drawLine(420,330,410,340);
				page.drawLine(410,310,410,330);
				page.drawLine(400,320,420,320);
				page.draw3DRect(400,310,20,20,true);
				page.setFont(OptionText);
				page.drawString("BLOCKED",400,360);
			}
			if(start==true)
			{
				enemyStats();
				start=false;
				page.setFont(OptionText);
				enemyTempHealth=enemyHealth;
				String healthText=Double.toString(gageTempHealth);
				page.drawString(healthText,350,400);
				String enemyHealthText=Double.toString(enemyTempHealth);
				page.drawString(enemyHealthText,100,120);
			}
			else if(start==false)
			{
				page.setFont(OptionText);
				String healthText=Double.toString(gageTempHealth);
				page.drawString(healthText,350,400);
				String enemyHealthText=Double.toString(enemyTempHealth);
				page.drawString(enemyHealthText,100,120);
				page.setColor(Color.red);
				String enemyDamageText=Integer.toString(-enemyTempDamage);
				page.drawString(enemyDamageText,500,330);
				String damageText=Integer.toString(-damage);
				page.drawString(damageText,40+r.nextInt(80),170+r.nextInt(25));
			}
			if(noMana==true)
			{
				page.setFont(BattleText);
				page.setColor(Color.blue);
				page.drawString("Not Enough Mana!",465,250);
				noMana=false;
			}
			if(lv50==false&&manaBurst==true)
			{
				page.setFont(BattleText);
				page.setColor(Color.red);
				page.drawString("Must Be level 50",450,250);
				manaBurst=false;
			}
			if(enemyTempHealth<=0)
			{
				exp();
			}
			if(gageTempHealth<=0)
			{
				GameState=12;
				repaint();
			}

			if(heal==true)
			{
				page.setFont(BattleText);
				page.setColor(Color.green);
				healHealth=(.25*health);
				if(gageTempHealth+healHealth>=health)
				{
					healHealth=health-gageTempHealth;
				}
				gageTempHealth=gageTempHealth+healHealth;
				page.drawString("Heal!",465,250);
				heal=false;
			}
			if(runTry==true)
			{


				runTry=false;
				if(ran==true)
				{
					page.setFont(TitleText);
					page.clearRect(0,0,700,600);
					page.drawRect(0,0,600,500);
					page.setColor(Color.green);
					page.drawString("Got Away",200,250);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
					}
					GameState=12;
					repaint();
				}
				else if(ran==false)
				{
					page.setFont(BattleText);
					page.setColor(Color.red);
					page.drawString("Couldn't escape",465,250);
				}
			}
			if(color==1)
			{
				page.setColor(Color.red);
			}
			else if(color==2)
			{
				page.setColor(Color.orange);
			}
			else if(color==3)
			{
				page.setColor(Color.yellow);
			}
			else if(color==4)
			{
				page.setColor(Color.green);
			}
			else if(color==5)
			{
				page.setColor(Color.cyan);
			}
			else if(color==6)
			{
				page.setColor(Color.blue);
			}
			else if(color==7)
			{
				page.setColor(Color.white);
			}
			else if(color==8)
			{
				page.setColor(Color.black);
			}
			else if(color==9)
			{
				page.setColor(Color.magenta);
			}
			if(enemyState==0)
			{
				page.fillRect(RectDim[0]+1,RectDim[1]+1,RectDim[2]-1,RectDim[3]-1);
				page.setColor(Color.black);
				page.drawRect(RectDim[0],RectDim[1],RectDim[2],RectDim[3]);

			}
			else if(enemyState==1)
			{
				page.drawOval(RectDim[0],RectDim[1],RectDim[2],RectDim[3]);
				page.fillOval(RectDim[0],RectDim[1],RectDim[2],RectDim[3]);

			}
			if(moveState==0)
			{

			}
			else if(moveState==1)//strike
			{
				for(int i=400;i>RectDim[2]+RectDim[0]+30;i--)
				{
					page.clearRect(i-20,160,70,160);
					page.setColor(Color.black);
					page.drawOval(i,160,40,40);
					page.drawLine(i+20,200,i+20,260);
					page.drawLine(i,280,i+20,260);
					page.drawLine(i+40,280,i+20,260);
					page.drawLine(i,240,i+20,230);
					page.drawLine(i+5,250,i+20,232);
					page.drawLine(i+10,250,i-10,220);
					page.drawLine(i+5,175,i+10,170);
					page.drawLine(i+7,172,i+7,180);

					try {Thread.sleep(1);
					} catch (InterruptedException e) {
					}
				}

				int y=r.nextInt(2);
				if(damage>0)
				{
					if(color==1)
					{
						page.setColor(Color.red);
					}
					else if(color==2)
					{
						page.setColor(Color.orange);
					}
					else if(color==3)
					{
						page.setColor(Color.yellow);
					}
					else if(color==4)
					{
						page.setColor(Color.green);
					}
					else if(color==5)
					{
						page.setColor(Color.cyan);
					}
					else if(color==6)
					{
						page.setColor(Color.blue);
					}
					else if(color==7)
					{
						page.setColor(Color.white);
					}
					else if(color==8)
					{
						page.setColor(Color.black); 
					}
					else if(color==9)
					{
						page.setColor(Color.magenta);
					}
					if(enemyState==0)
					{
						page.fillRect(RectDim[0]+1,RectDim[1]+1,RectDim[2]-1,RectDim[3]-1);
						page.setColor(Color.black);
						page.drawRect(RectDim[0],RectDim[1],RectDim[2],RectDim[3]);
						page.clearRect(RectDim[0],RectDim[1],RectDim[2],RectDim[3]);
					}
					else if(enemyState==1)
					{
						page.fillOval(RectDim[0]+1,RectDim[1]+1,RectDim[2]-1,RectDim[3]-1);
						page.setColor(Color.black);
						page.drawOval(RectDim[0],RectDim[1],RectDim[2],RectDim[3]);
						page.clearRect(RectDim[0],RectDim[1],RectDim[2],RectDim[3]);
					}

					for(int i=0;i<10;i++)
					{
						if(color==1)
						{
							page.setColor(Color.red);
						}
						else if(color==2)
						{
							page.setColor(Color.orange);
						}
						else if(color==3)
						{
							page.setColor(Color.yellow);
						}
						else if(color==4)
						{
							page.setColor(Color.green);
						}
						else if(color==5)
						{
							page.setColor(Color.cyan);
						}
						else if(color==6)
						{
							page.setColor(Color.blue);
						}
						else if(color==7)
						{
							page.setColor(Color.white);
						}
						else if(color==8)
						{
							page.setColor(Color.black);
						}
						if(enemyState==0)
						{
							page.clearRect(RectDim[0]-8,RectDim[1]-8,RectDim[2]+16,RectDim[3]+16);
							int x=r.nextInt(8);
							page.fillRect(RectDim[0]+x-4,RectDim[1]+x-4,RectDim[2],RectDim[3]);
							page.setColor(Color.black);
							page.drawRect(RectDim[0]+x-4,RectDim[1]+x-4,RectDim[2],RectDim[3]);
						}
						else if(enemyState==1)
						{
							page.clearRect(RectDim[0]-8,RectDim[1]-8,RectDim[2]+16,RectDim[3]+16);
							int x=r.nextInt(8);
							page.fillOval(RectDim[0]+x-4,RectDim[1]+x-4,RectDim[2],RectDim[3]);
							page.setColor(Color.black);
							page.drawOval(RectDim[0]+x-4,RectDim[1]+x-4,RectDim[2],RectDim[3]);
						}
						try {
							Thread.sleep(15);
						} catch (InterruptedException e) {
						}
					}
				}


				page.setColor(Color.MAGENTA);
				if(y==0)
				{
					int a=r.nextInt(20);
					int b=r.nextInt(20);
					int c=r.nextInt(20);
					int d=r.nextInt(20);
					page.drawLine(RectDim[0]-a,RectDim[1]-b,RectDim[0]+RectDim[2]+c,RectDim[1]+RectDim[3]+d);
					page.setColor(Color.green);
					page.drawLine(RectDim[0]-a,RectDim[1]-b+1,RectDim[0]+RectDim[2]+c,RectDim[1]+RectDim[3]+d+1);
					page.drawLine(RectDim[0]-a,RectDim[1]-b-1,RectDim[0]+RectDim[2]+c,RectDim[1]+RectDim[3]+d-1);
				}
				else if(y==1)
				{
					int a=r.nextInt(20);
					int b=r.nextInt(20);
					int c=r.nextInt(20);
					int d=r.nextInt(20);
					page.drawLine(RectDim[0]-a,RectDim[1]+RectDim[3]+b,RectDim[0]+RectDim[2]+c,RectDim[1]+d);
					page.setColor(Color.green);
					page.drawLine(RectDim[0]-a,RectDim[1]+RectDim[3]+b+1,RectDim[0]+RectDim[2]+c,RectDim[1]+d+1);
					page.drawLine(RectDim[0]-a,RectDim[1]+RectDim[3]+b-1,RectDim[0]+RectDim[2]+c,RectDim[1]+d-1);
				}
				page.clearRect(RectDim[0]+RectDim[2]+20,160,70,160);
				moveState=0;
			}
			else if(moveState==2)//special strike
			{
				for(int i=400;i>RectDim[2]+RectDim[0]+30;i--)
				{
					page.clearRect(i-20,160,70,160);
					page.setColor(Color.black);
					page.drawOval(i,160,40,40);
					page.drawLine(i+20,200,i+20,260);
					page.drawLine(i,280,i+20,260);
					page.drawLine(i+40,280,i+20,260);
					page.drawLine(i,240,i+20,230);
					page.drawLine(i+5,250,i+20,232);
					page.drawLine(i+10,250,i-10,220);
					page.drawLine(i+5,175,i+10,170);
					page.drawLine(i+7,172,i+7,180);

					try {Thread.sleep(1);
					} catch (InterruptedException e) {
					}
				}
				if(damage>0)
				{
					if(color==1)
					{
						page.setColor(Color.red);
					}
					else if(color==2)
					{
						page.setColor(Color.orange);
					}
					else if(color==3)
					{
						page.setColor(Color.yellow);
					}
					else if(color==4)
					{
						page.setColor(Color.green);
					}
					else if(color==5)
					{
						page.setColor(Color.cyan);
					}
					else if(color==6)
					{
						page.setColor(Color.blue);
					}
					else if(color==7)
					{
						page.setColor(Color.white);
					}
					else if(color==8)
					{
						page.setColor(Color.black);
					}
					else if(color==9)
					{
						page.setColor(Color.magenta);
					}
					if(enemyState==0)
					{
						page.fillRect(RectDim[0]+1,RectDim[1]+1,RectDim[2]-1,RectDim[3]-1);
						page.setColor(Color.black);
						page.drawRect(RectDim[0],RectDim[1],RectDim[2],RectDim[3]);
						page.clearRect(RectDim[0],RectDim[1],RectDim[2],RectDim[3]);
					}
					if(enemyState==1)
					{
						page.fillOval(RectDim[0]+1,RectDim[1]+1,RectDim[2]-1,RectDim[3]-1);
						page.setColor(Color.black);
						page.drawOval(RectDim[0],RectDim[1],RectDim[2],RectDim[3]);
						page.clearRect(RectDim[0],RectDim[1],RectDim[2],RectDim[3]);
					}
					for(int i=0;i<10;i++)
					{
						if(color==1)
						{
							page.setColor(Color.red);
						}
						else if(color==2)
						{
							page.setColor(Color.orange);
						}
						else if(color==3)
						{
							page.setColor(Color.yellow);
						}
						else if(color==4)
						{
							page.setColor(Color.green);
						}
						else if(color==5)
						{
							page.setColor(Color.cyan);
						}
						else if(color==6)
						{
							page.setColor(Color.blue);
						}
						else if(color==7)
						{
							page.setColor(Color.white);
						}
						else if(color==8)
						{
							page.setColor(Color.black);
						}
						if(enemyState==0)
						{
							page.clearRect(RectDim[0]-16,RectDim[1]-16,RectDim[2]+32,RectDim[3]+32);
							int x=r.nextInt(16);
							page.fillRect(RectDim[0]+x-8,RectDim[1]+x-8,RectDim[2],RectDim[3]);
							page.setColor(Color.black);
							page.drawRect(RectDim[0]+x-8,RectDim[1]+x-8,RectDim[2],RectDim[3]);
						}
						else if(enemyState==1)
						{
							page.clearRect(RectDim[0]-16,RectDim[1]-16,RectDim[2]+32,RectDim[3]+32);
							int x=r.nextInt(16);
							page.fillOval(RectDim[0]+x-8,RectDim[1]+x-8,RectDim[2],RectDim[3]);
							page.setColor(Color.black);
							page.drawOval(RectDim[0]+x-8,RectDim[1]+x-8,RectDim[2],RectDim[3]);
						}
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
						}
					}
				}
				page.setColor(Color.magenta);
				int a=r.nextInt(20);
				int b=r.nextInt(20);
				int c=r.nextInt(20);
				int d=r.nextInt(20);
				page.drawLine(RectDim[0]-a,RectDim[1]-b,RectDim[0]+RectDim[2]+c,RectDim[1]+RectDim[3]+d);
				page.setColor(Color.green);
				page.drawLine(RectDim[0]-a,RectDim[1]-b+1,RectDim[0]+RectDim[2]+c,RectDim[1]+RectDim[3]+d+1);
				page.drawLine(RectDim[0]-a,RectDim[1]-b-1,RectDim[0]+RectDim[2]+c,RectDim[1]+RectDim[3]+d-1);
				page.setColor(Color.magenta);
				int e=r.nextInt(20);
				int f=r.nextInt(20);
				int g=r.nextInt(20);
				int h=r.nextInt(20);
				page.drawLine(RectDim[0]-e,RectDim[1]+RectDim[3]+f,RectDim[0]+RectDim[2]+g,RectDim[1]+h);
				page.setColor(Color.green);
				page.drawLine(RectDim[0]-e,RectDim[1]+RectDim[3]+f+1,RectDim[0]+RectDim[2]+g,RectDim[1]+h+1);
				page.drawLine(RectDim[0]-e,RectDim[1]+RectDim[3]+f-1,RectDim[0]+RectDim[2]+g,RectDim[1]+h-1);
				moveState=0;
				page.clearRect(RectDim[0]+RectDim[2]+20,160,70,160);
			}
			else if(moveState==3)//mana regen
			{
				page.setColor(Color.blue);
				page.fillRect(400,120,10,50);
				page.fillRect(380,140,50,10);
				for(int i=0;i<30;i++)
				{
					page.clearRect(350,100,120,120);
					page.fillRect(400,120-i,10,50);
					page.fillRect(380,140-i,50,10);
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
					}

				}
				moveState=0;
			}
			else if(moveState==4)//mana burst
			{


				page.clearRect(210,100,200,100);
				page.setColor(Color.blue);
				page.fillOval(350,200,50,50);
				page.setColor(Color.black);
				page.drawOval(350,200,50,50);
				for(int i=350;i>RectDim[0]+RectDim[2];i--)
				{
					page.clearRect(i,190,60,70);
					page.setColor(Color.blue);
					page.fillOval(i,200,50,50);
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
					}
					page.clearRect(i,190,60,70);
				}
				page.drawLine(RectDim[0]+RectDim[2]-r.nextInt(4),RectDim[1]+5+r.nextInt(5),RectDim[0]+RectDim[2]+r.nextInt(30)+10,RectDim[1]+5-r.nextInt(10));
				page.drawLine(RectDim[0]+RectDim[2]-r.nextInt(4),RectDim[1]+5+r.nextInt(5),RectDim[0]+RectDim[2]+r.nextInt(30)+10,RectDim[1]+5-r.nextInt(10));
				page.drawLine(RectDim[0]+RectDim[2]-r.nextInt(4),RectDim[1]+5+r.nextInt(5),RectDim[0]+RectDim[2]+r.nextInt(30)+10,RectDim[1]+5-r.nextInt(10));
				page.drawLine(RectDim[0]+RectDim[2]-r.nextInt(4),RectDim[1]+5+r.nextInt(5),RectDim[0]+RectDim[2]+r.nextInt(30)+10,RectDim[1]+5-r.nextInt(10));
				page.drawLine(RectDim[0]+RectDim[2]-r.nextInt(4),RectDim[1]+20+r.nextInt(5),RectDim[0]+RectDim[2]+r.nextInt(30)+10,RectDim[1]+20+r.nextInt(10));
				page.drawLine(RectDim[0]+RectDim[2]-r.nextInt(4),RectDim[1]+20+r.nextInt(5),RectDim[0]+RectDim[2]+r.nextInt(30)+10,RectDim[1]+20+r.nextInt(10));
				page.drawLine(RectDim[0]+RectDim[2]-r.nextInt(4),RectDim[1]+20+r.nextInt(5),RectDim[0]+RectDim[2]+r.nextInt(30)+10,RectDim[1]+20+r.nextInt(10));
				page.drawLine(RectDim[0]+RectDim[2]-r.nextInt(4),RectDim[1]+20+r.nextInt(5),RectDim[0]+RectDim[2]+r.nextInt(30)+10,RectDim[1]+20+r.nextInt(10));
				page.drawLine(RectDim[0]+RectDim[2]-r.nextInt(4),RectDim[1]+10+r.nextInt(5),RectDim[0]+RectDim[2]+r.nextInt(30)+10,RectDim[1]+20+r.nextInt(10));
				page.drawLine(RectDim[0]+RectDim[2]-r.nextInt(4),RectDim[1]+10+r.nextInt(5),RectDim[0]+RectDim[2]+r.nextInt(30)+10,RectDim[1]+20+r.nextInt(10));
				page.drawLine(RectDim[0]+RectDim[2]-r.nextInt(4),RectDim[1]+10+r.nextInt(5),RectDim[0]+RectDim[2]+r.nextInt(30)+10,RectDim[1]+20+r.nextInt(10));
				page.drawLine(RectDim[0]+RectDim[2]-r.nextInt(4),RectDim[1]+10+r.nextInt(5),RectDim[0]+RectDim[2]+r.nextInt(30)+10,RectDim[1]+20+r.nextInt(10));


				for(int i=RectDim[0];i>75;i--)
				{
					if(color==1)
					{
						page.setColor(Color.red);
					}
					else if(color==2)
					{
						page.setColor(Color.orange);
					}
					else if(color==3)
					{
						page.setColor(Color.yellow);
					}
					else if(color==4)
					{
						page.setColor(Color.green);
					}
					else if(color==5)
					{
						page.setColor(Color.cyan);
					}
					else if(color==6)
					{
						page.setColor(Color.blue);
					}
					else if(color==7)
					{
						page.setColor(Color.white);
					}
					else if(color==8)
					{
						page.setColor(Color.black); 
					}	
					if(enemyState==0)
					{
						page.clearRect(i-2,RectDim[1]-2,RectDim[2]+4,RectDim[3]+4);
						page.fillRect(i+1,RectDim[1]+1,RectDim[2]-1,RectDim[3]-1);
						page.setColor(Color.black);
						page.drawRect(i,RectDim[1],RectDim[2],RectDim[3]);
					}
					else if(enemyState==1)
					{
						page.clearRect(i-2,RectDim[1]-2,RectDim[2]+4,RectDim[3]+4);
						page.fillOval(i+1,RectDim[1]+1,RectDim[2]-1,RectDim[3]-1);
						page.setColor(Color.black);
						page.drawOval(i,RectDim[1],RectDim[2],RectDim[3]);
					}
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
					}
				}
				moveState=0;
			}
			else if(moveState==5)//heal
			{
				page.setColor(Color.black);
				page.drawOval(400,160,40,40);
				page.drawLine(420,200,420,260);
				page.drawLine(400,280,420,260);
				page.drawLine(440,280,420,260);
				page.drawLine(400,240,420,230);
				page.drawLine(405,250,420,232);
				page.drawLine(410,250,390,220);
				page.drawLine(405,175,410,170);
				page.drawLine(407,172,407,180);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e){


				}
				page.setColor(Color.black);
				page.drawOval(400,160,40,40);
				page.drawLine(420,200,420,260);
				page.drawLine(400,280,420,260);
				page.drawLine(440,280,420,260);
				page.drawLine(400,240,420,230);
				page.drawLine(405,250,420,232);
				page.drawLine(410,250,390,220);
				page.drawLine(420,160,410,150);


				page.setColor(Color.green);
				page.fillRect(400,120,10,50);
				page.fillRect(380,140,50,10);
				for(int i=0;i<30;i++)
				{
					page.clearRect(350,100,120,120);
					page.fillRect(400,120-i,10,50);
					page.fillRect(380,140-i,50,10);
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
					}

				}
				moveState=0;
			}
			page.setColor(Color.black);


			page.drawRect(480,220,100,10);
			page.setFont(MoveText);
			page.drawString("Mana Regen:",480,400);
			String regenText=Integer.toString(manaRegen);
			page.drawString(regenText,565,400);
			page.setFont(OptionText);
			page.drawString(enemyName,30,40);
			String manaText=Integer.toString(tempMana);
			page.drawString(manaText, 500, 200);
			page.drawString("Mana:",500, 175);
			page.setColor(Color.orange);
			page.drawRect(230,450,70,40);
			page.drawRect(300,450,70,40);
			page.drawRect(370,450,70,40);
			page.drawRect(440,450,70,40);
			page.drawRect(510,450,70,40);
			page.drawRect(500,10,70,40);
			page.drawRect(100,420,300,20);
			page.drawRect(100,50,300,20);
			page.setFont(MoveText);
			page.setColor(Color.blue);
			page.drawString("Attack",245,475);
			page.drawString("Special", 310, 465);
			page.drawString("Strike",310,480);
			page.drawString("Mana",381,465);
			page.drawString("Regen",380,480);
			page.drawString("Mana",450,465);
			page.drawString("Burst",450,480);
			page.drawString("Heal",525,475);
			page.drawString("Run",520,35);
			page.setColor(Color.black);
			page.drawOval(400,160,40,40);
			page.drawLine(420,200,420,260);
			page.drawLine(400,280,420,260);
			page.drawLine(440,280,420,260);
			page.drawLine(400,240,420,230);
			page.drawLine(405,250,420,232);
			page.drawLine(410,250,390,220);
			page.drawLine(405,175,410,170);
			page.setColor(Color.red);
			page.drawLine(407,172,407,180);

			for(int i=100*tempMana/mana+480;i>=480;i--)
			{
				page.setColor(Color.blue);
				page.drawLine(i,220,i,230);
				page.setColor(Color.black);
				page.drawRect(480,220,100,10);
			}

			for(int i=(int)(300*enemyTempHealth/enemyHealth+100);i>=100;i--)
			{
				page.setColor(Color.green);
				page.drawLine(i,50,i,70);
				page.setColor(Color.black);
				page.drawRect(100,50,300,20);

			}
			for(int i=(int)(300*gageTempHealth/health+100);i>=100;i--)
			{
				page.setColor(Color.green);
				page.drawLine(i,420,i,440);
				page.setColor(Color.black);
				page.drawRect(100,420,300,20);

			}


		}
		//Boss Battles//
		else if(GameState==4)
		{

			if(bossZone==true)
			{
				page.setFont(BattleText);
				page.drawString("Need to be Past Zone",180,480);
				String bossReq=Integer.toString(bossZoneReq);
				page.drawString(bossReq,338,480);
				bossZone=false;
			}
			page.setFont(MenuText);
			page.drawString("Boss Battles",150,50);
			page.setFont(OptionText);
			page.drawString("Boss 1",optionLeft+20,115);
			page.drawString("Boss 2",optionLeft+20,215);
			page.drawString("Boss 3",optionLeft+20,315);
			page.drawString("Boss 4",optionLeft+20,415);
			page.drawString("Boss 5",optionRight+20,115);
			page.drawString("Boss 6",optionRight+20,215);
			page.drawString("Secret",optionRight+20,315);
			page.drawString("Back",optionRight+30,415);
			page.drawRect(optionLeft,75,optionWidth,optionHeight);
			page.drawRect(optionLeft,175,optionWidth,optionHeight);
			page.drawRect(optionLeft,275,optionWidth,optionHeight);
			page.drawRect(optionLeft,375,optionWidth,optionHeight);
			page.drawRect(optionRight,75,optionWidth,optionHeight);
			page.drawRect(optionRight,175,optionWidth,optionHeight);
			page.drawRect(optionRight,275,optionWidth,optionHeight);
			page.drawRect(optionRight,375,optionWidth,optionHeight);
		}
		//Zones//
		else if(GameState==5)
		{
			if(notZone==true)
			{
				page.setFont(BattleText);
				page.drawString("Need to be Unlock Zone",180,480);
				String bossReq=Integer.toString(zoneReq);
				page.drawString(bossReq,338,480);
				notZone=false;
			}
			page.setFont(MenuText);
			page.drawString("ZONES",230,50);
			page.setFont(OptionText);
			page.drawString("ZONE 1",optionLeft+15,115);
			page.drawString("ZONE 2",optionLeft+15,215);
			page.drawString("ZONE 3",optionLeft+15,315);
			page.drawString("ZONE 4",optionLeft+15,415);
			page.drawString("ZONE 5",optionRight+15,115);
			page.drawString("ZONE 6",optionRight+15,215);
			page.drawString("ZONE 7",optionRight+15,315);
			page.drawString("Back",optionRight+30,415);
			page.drawRect(optionLeft,75,optionWidth,optionHeight);
			page.drawRect(optionLeft,175,optionWidth,optionHeight);
			page.drawRect(optionLeft,275,optionWidth,optionHeight);
			page.drawRect(optionLeft,375,optionWidth,optionHeight);
			page.drawRect(optionRight,75,optionWidth,optionHeight);
			page.drawRect(optionRight,175,optionWidth,optionHeight);
			page.drawRect(optionRight,275,optionWidth,optionHeight);
			page.drawRect(optionRight,375,optionWidth,optionHeight);
		}
		//Info//
		else if(GameState==6)
		{

			page.setFont(OptionText);
			page.drawString("Stats",300,50);
			page.drawString("Strength:",100,100);
			String text1 = Integer.toString(strength);
			page.drawString(text1,250,100);


		}
		//Extra//
		else if(GameState==7) 	
		{
			page.setFont(MenuText);
			page.drawString("Extra",200,50);
			page.setFont(OptionText);
			page.drawString("About",optionLeft+20,115);
			page.drawString("Info",optionLeft+20,215);
			page.drawString("Instructions",optionLeft+20,315);
			page.drawString("Back",optionLeft+20,415);
			page.drawString("",optionRight+20,115);
			page.drawString("",optionRight+20,215);
			page.drawString("",optionRight+20,315);
			page.drawString("",optionRight+30,415);
			page.drawRect(optionLeft,75,optionWidth,optionHeight);
			page.drawRect(optionLeft,175,optionWidth,optionHeight);
			page.drawRect(optionLeft,275,optionWidth,optionHeight);
			page.drawRect(optionLeft,375,optionWidth,optionHeight);
			page.drawRect(optionRight,75,optionWidth,optionHeight);
			page.drawRect(optionRight,175,optionWidth,optionHeight);
			page.drawRect(optionRight,275,optionWidth,optionHeight);
			page.drawRect(optionRight,375,optionWidth,optionHeight);
		}
		//Save//
		else if(GameState==8)
		{
			try {
				save();
			} catch (IOException e1) {

			}
			page.setFont(SaveText);
			page.drawString("You saved the game, congradu-fucking-lations",150,200);
		}
		//tokens//
		else if(GameState==9)
		{
			page.setFont(OptionText);
			levelUp=false;
			if(manaRegenGain==true)
			{
				page.setColor(Color.orange);
				tempManaRegen1=r.nextInt(11)+10;
				gain=Integer.toString(tempManaRegen1);
				page.drawString("Mana Regen Gain",150,350);
				manaRegen=tempManaRegen1+manaRegen;
				manaRegenGain=false;
			}
			if(strengthGain==true)
			{
				page.setColor(Color.red);
				tempStrength1=r.nextInt(3)+1;
				strength=tempStrength1+strength;
				gain=Integer.toString(tempStrength1);
				page.drawString("Strength Gain",175,350);
				strengthGain=false;
			}
			if(manaGain==true)
			{
				page.setColor(Color.blue);
				tempMana1=r.nextInt(41)+10;
				gain=Integer.toString(tempMana1);
				page.drawString("Mana Gain",175,350);
				mana=tempMana1+mana;
				manaGain=false;
			}
			if(healthGain==true)
			{
				page.setColor(Color.green);
				tempHealth1=r.nextInt(6)+5;
				gain=Integer.toString(tempHealth1);
				page.drawString("Health Gain",180,350);
				health=tempHealth1+health;
				healthGain=false;
			}
			if(Gain==true)
			{
				page.setColor(Color.black);
				page.drawRect(200,400,130,70);
				page.drawString(gain,250, 435);
				Gain=false;
			}
			tokensGiven=r.nextInt(enemyTokens);
			page.setColor(Color.CYAN);
			page.drawString("Tokens Recieved:", 150, 200);
			page.drawString("Tokens:",200,250);
			tokens=tokens+tokensGiven;
			String tokenText1=Integer.toString(tokens);
			page.drawString(tokenText1,300,250);

			if(tokensGiven==0)
			{
				page.drawString("0",375,200);
			}
			else if(tokensGiven>0)
			{
				for(int h=1;h<=tokensGiven;h++)
				{
					for(int i=400;i>200;i--)
					{
						page.clearRect(400-1,i-1,70+2,70+4);
						page.setColor(Color.gray);
						page.fillOval(400,i,70,70);
						page.setColor(Color.black);
						page.drawOval(400,i,70,70);
						page.drawRect(410,i+15,50,10);
						page.drawRect(430,i+20,10,40);
						page.fillRect(410,i+15,50,10);
						page.fillRect(430,i+20,10,40);
						try {
							Thread.sleep(2);
						} catch (InterruptedException e) {
						}
					}

					String tokenText=Integer.toString(h);
					page.clearRect(355,160,40,40);
					page.drawString(tokenText,375,200);
				}	

			}

		}
		//experience//
		else if(GameState==10)
		{
			page.setFont(TitleText);
			page.drawString("YOU WIN!",200,50);
			page.drawRect(100,200,400,30);
			page.setFont(OptionText);
			page.drawString("Experience:",250,150);
			page.setColor(Color.yellow);
			if(experience>=1000)
			{

				for(int i=100;i<=400*experience/1000+100;i++)
				{
					page.setColor(Color.yellow);
					page.drawLine(i,200,i,230);
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
					}
					page.setColor(Color.black);
					page.drawRect(100,200,400,30);
				}
				experience=experience-1000;
				level++;
				levelUp=true;
				page.drawString("Level:",250, 310);
				String levelText=Integer.toString(level);
				page.drawString(levelText,330,310);
				page.drawString("Level Up!",250,280);

			}
			else if(experience<1000)
			{

				page.clearRect(101,201,399,29);
				for(int i=100;i<=400*experience/1000+100;i++)
				{
					page.setColor(Color.yellow);
					page.drawLine(i,200,i,230);
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
					}
					page.setColor(Color.black);
					page.drawRect(100,200,400,30);
				}
				page.drawString("Experience Till Next Level:",25,350);
				ExpTNL=1000-experience;
				String expText=Double.toString(ExpTNL);
				page.drawString(expText,350,350);
			}
		}
		//level up//
		else if(GameState==11)
		{
			page.setFont(OptionText);
			page.drawString("Stat Increases",100,50);
			page.drawRect(200,100,130,70);
			page.drawRect(200,200,130,70);
			page.drawRect(200,300,130,70);
			page.drawRect(200,400,130,70);
			page.setColor(Color.red);
			page.drawString("Strength",220,145);
			page.setColor(Color.green);
			page.drawString("Health",220,245);
			page.setColor(Color.blue);
			page.drawString("Mana",220,345);
			page.setColor(Color.orange);
			page.drawString("Mana",230,425);
			page.drawString("Regen",220,455);
		}
		//Lose Screen//
		else if(GameState==12)
		{
			page.setFont(TitleText);
			page.drawString("You Lose!",200,200);
			page.drawString("Tokens Lost:",100,300);
			if(ran=true)
			{
				tokensLost=1;
			}
			else
			{
				tokensLost=tokens;
			}
			if(tokens==0)
			{
				tokensLost=0;
			}
			tokens=tokens-tokensLost;
			String tokenText=Integer.toString(tokensLost);
			page.drawString(tokenText,350,300);
			tokenLoss(tokensLost);
		}
		//Next Battle Screen//
		else if(GameState==13)
		{
			battle();
			page.setFont(TitleText);
			page.drawString(enemyName,100,200);
			String zoneText=Integer.toString(zone);
			String stageText=Integer.toString(stage);
			page.drawString("Stage:",170,300);
			page.drawString(stageText,300,300);
			page.drawString("Zone:",180,400);
			page.drawString(zoneText,300,400);

		}
		//Zone x//
		else if(GameState==14)
		{
			page.drawOval(20,100,75,75);
			page.drawOval(120,100,75,75);
			page.drawOval(220,100,75,75);
			page.drawRect(200,300,100,50);
		}

		//Game Progression//
		else if(GameState==15)
		{
			if(training==true)
			{
				GameState=1;
				repaint();
			}
			if(nextBattle==true)
			{
				page.setFont(TitleText);
				stage();
				nextBattleEnemy++;
				page.drawString("Stage Complete",100,200);
				String zoneText=Integer.toString(zone);
				String stageText=Integer.toString(stage);
				page.drawString("Stage:",170,300);
				page.drawString(stageText,300,300);
				page.drawString("Zone:",180,400);
				page.drawString(zoneText,300,400);
			}
			if(bossBattle==true)
			{
				page.setColor(Color.blue);
				page.setFont(MenuText);
				page.drawString("Boss Defeated",100,100);
				int manaGiven=bossBattleEnemy;
				mana=manaGiven+mana;
				String manaText=Integer.toString(manaGiven);
				page.drawString("Mana Given:",100,200);
				page.drawString(manaText,400,200);


			}
		}

		//shop screen//
		else if(GameState==16)
		{
			if(noTokens==true)
			{
				page.setFont(BattleText);
				page.drawString("Not Enough Tokens",180,480);
				noTokens=false;
			}
			page.setFont(BattleText);
			page.drawString("Tokens:",210,100);
			String tokenText=Integer.toString(tokens);
			page.drawString(tokenText,270,100);
			page.setFont(MenuText);
			page.drawString("SHOP",230,50);
			page.setFont(MoveText);
			page.drawString("Strength Boost",optionLeft+5,100);
			page.drawString("Health Boost",optionLeft+5,200);
			page.drawString("Defense Boost",optionLeft+5,300);
			page.drawString("Mana Boost",optionLeft+5,400);
			page.drawString("Mana Regen Boost",optionRight+5,100);
			page.drawString("Level Boost",optionRight+5,200);
			page.drawString("Zone Unlock",optionRight+5,300);
			page.drawString("Back",optionRight+30,400);
			page.drawString("Cost:10",optionLeft+30,130);
			page.drawString("Cost:10",optionLeft+30,230);
			page.drawString("Cost:10",optionLeft+30,330);
			page.drawString("Cost:10",optionLeft+30,430);
			page.drawString("Cost:10",optionRight+30,130);
			page.drawString("Cost:20",optionRight+30,230);
			page.drawString("Cost:20",optionRight+30,330);
			page.drawRect(optionLeft,75,optionWidth,optionHeight);
			page.drawRect(optionLeft,175,optionWidth,optionHeight);
			page.drawRect(optionLeft,275,optionWidth,optionHeight);
			page.drawRect(optionLeft,375,optionWidth,optionHeight);
			page.drawRect(optionRight,75,optionWidth,optionHeight);
			page.drawRect(optionRight,175,optionWidth,optionHeight);
			page.drawRect(optionRight,275,optionWidth,optionHeight);
			page.drawRect(optionRight,375,optionWidth,optionHeight);
		}
		//zone graphics//
		else if(GameState==17)
		{
			if(tempZone==1)
			{
				Image zone1=getImage(getCodeBase(),"zone1.gif");
				page.drawImage(zone1,30,40,this);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e2) {
				}
			}
			else if(tempZone==2)
			{

			}



		}
		//shop graphics
		else if(GameState==18)
		{
			if(buyItem==1)
			{
				page.setFont(OptionText);
				int x=r.nextInt(2)+1;
				page.drawString("Strength Given:",150,100);
				page.drawString("Strength Boost!",150,50);
				String strengthText=Integer.toString(x);
				strength=strength+x;
				page.drawString(strengthText,350,100);
				page.drawLine(300,200,320,200);
				page.drawLine(300,200,300,250);
				page.drawLine(320,200,320,250);
				page.drawPolygon(p);
				page.clearRect(301,201,18,48);
				page.setColor(Color.red);
				page.fillRect(301,221,19,28);
				page.fillPolygon(p);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
				}
				int a=0;
				for(int i=201;i<250;i++)
				{
					page.setColor(Color.white);
					page.drawLine(301,i,319,i);
					try {
						Thread.sleep(8);
					} catch (InterruptedException e) {
					}
				}
				for(int i=250;i<300;i++)
				{
					page.setColor(Color.white);
					page.drawLine(301-a,i,319+a,i);
					a++;
					page.setColor(Color.black);
					page.drawLine(310,240,250,300);
					page.clearRect(301,201,18,48);
					try {
						Thread.sleep(8);
					} catch (InterruptedException e) {
					}
				}

			}
			else if(buyItem==2)
			{
				page.setFont(OptionText);
				int x=r.nextInt(5)+1;
				page.drawString("Health Given:",150,100);
				page.drawString("Health Boost!",150,50);
				String strengthText=Integer.toString(x);
				health=health+x;
				page.drawString(strengthText,350,100);
				page.drawLine(300,200,320,200);
				page.drawLine(300,200,300,250);
				page.drawLine(320,200,320,250);
				page.drawPolygon(p);
				page.clearRect(301,201,18,48);
				page.setColor(Color.green);
				page.fillRect(301,221,19,28);
				page.fillPolygon(p);
				int a=0;
				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
				}
				for(int i=201;i<250;i++)
				{
					page.setColor(Color.white);
					page.drawLine(301,i,319,i);
					try {
						Thread.sleep(8);
					} catch (InterruptedException e) {
					}
				}
				for(int i=250;i<300;i++)
				{
					page.setColor(Color.white);
					page.drawLine(301-a,i,319+a,i);
					a++;
					page.setColor(Color.black);
					page.drawLine(310,240,250,300);
					page.clearRect(301,201,18,48);
					try {
						Thread.sleep(8);
					} catch (InterruptedException e) {
					}
				}

			}
			else if(buyItem==3)
			{
				page.setFont(OptionText);
				int x=r.nextInt(2)+1;
				page.drawString("Defense Given:",150,100);
				page.drawString("Defense Boost!",150,50);
				String strengthText=Integer.toString(x);
				manaRegen=manaRegen+x;
				page.drawString(strengthText,350,100);
				page.drawLine(300,200,320,200);
				page.drawLine(300,200,300,250);
				page.drawLine(320,200,320,250);
				page.drawPolygon(p);
				page.clearRect(301,201,18,48);
				page.setColor(Color.cyan);
				page.fillRect(301,221,19,28);
				page.fillPolygon(p);
				int a=0;
				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
				}
				for(int i=201;i<250;i++)
				{
					page.setColor(Color.white);
					page.drawLine(301,i,319,i);
					try {
						Thread.sleep(8);
					} catch (InterruptedException e) {
					}
				}
				for(int i=250;i<300;i++)
				{
					page.setColor(Color.white);
					page.drawLine(301-a,i,319+a,i);
					a++;
					page.setColor(Color.black);
					page.drawLine(310,240,250,300);
					page.clearRect(301,201,18,48);
					try {
						Thread.sleep(8);
					} catch (InterruptedException e) {
					}
				}


			}
			else if(buyItem==4)
			{
				page.setFont(OptionText);
				int x=r.nextInt(40)+1;
				page.drawString("Mana Given:",150,100);
				page.drawString("Mana Boost!",150,50);
				String strengthText=Integer.toString(x);
				manaRegen=manaRegen+x;
				page.drawString(strengthText,350,100);
				page.drawLine(300,200,320,200);
				page.drawLine(300,200,300,250);
				page.drawLine(320,200,320,250);
				page.drawPolygon(p);
				page.clearRect(301,201,18,48);
				page.setColor(Color.blue);
				page.fillRect(301,221,19,28);
				page.fillPolygon(p);
				int a=0;
				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
				}
				for(int i=201;i<250;i++)
				{
					page.setColor(Color.white);
					page.drawLine(301,i,319,i);
					try {
						Thread.sleep(8);
					} catch (InterruptedException e) {
					}
				}
				for(int i=250;i<300;i++)
				{
					page.setColor(Color.white);
					page.drawLine(301-a,i,319+a,i);
					a++;
					page.setColor(Color.black);
					page.drawLine(310,240,250,300);
					page.clearRect(301,201,18,48);
					try {
						Thread.sleep(8);
					} catch (InterruptedException e) {
					}
				}

			}
			else if(buyItem==5)
			{
				page.setFont(OptionText);
				int x=r.nextInt(20)+1;
				page.drawString("Mana Regen Given:",150,100);
				page.drawString("Mana Regen Boost!",150,50);
				String strengthText=Integer.toString(x);
				manaRegen=manaRegen+x;
				page.drawString(strengthText,450,100);
				page.drawLine(300,200,320,200);
				page.drawLine(300,200,300,250);
				page.drawLine(320,200,320,250);
				page.drawPolygon(p);
				page.clearRect(301,201,18,48);
				page.setColor(Color.orange);
				page.fillRect(301,221,19,28);
				page.fillPolygon(p);
				int a=0;
				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
				}
				for(int i=201;i<250;i++)
				{
					page.setColor(Color.white);
					page.drawLine(301,i,319,i);
					try {
						Thread.sleep(8);
					} catch (InterruptedException e) {
					}
				}
				for(int i=250;i<300;i++)
				{
					page.setColor(Color.white);
					page.drawLine(301-a,i,319+a,i);
					a++;
					page.setColor(Color.black);
					page.drawLine(310,240,250,300);
					page.clearRect(301,201,18,48);
					try {
						Thread.sleep(8);
					} catch (InterruptedException e) {
					}
				}

			}
			else if(buyItem==6)
			{
				page.setFont(OptionText);
				page.drawString("Experience Given:",150,100);
				page.drawString("Level Boost!",150,50);
				experience=experience+1000;
				page.drawString("1000",360,100);
				page.drawLine(300,200,320,200);
				page.drawLine(300,200,300,250);
				page.drawLine(320,200,320,250);
				page.drawPolygon(p);

				page.clearRect(301,201,18,48);
				page.setColor(Color.yellow);
				page.fillRect(301,221,19,28);
				page.fillPolygon(p);
				int a=0;
				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
				}
				for(int i=201;i<250;i++)
				{
					page.setColor(Color.white);
					page.drawLine(301,i,319,i);
					try {
						Thread.sleep(8);
					} catch (InterruptedException e) {
					}
				}
				for(int i=250;i<300;i++)
				{
					page.setColor(Color.white);
					page.drawLine(301-a,i,319+a,i);
					a++;
					page.setColor(Color.black);
					page.drawLine(310,240,250,300);
					page.clearRect(301,201,18,48);
					try {
						Thread.sleep(8);
					} catch (InterruptedException e) {
					}
				}
			}
			else if(buyItem==7)
			{
				if(zone<=6)
				{

					zone++;
				}
				if(zone>6)
				{
					page.drawString("Reached Highest Zone",200,100);
				}
			}
		}
		//mouse exit screen//
	}


public void stage()
{
	if(nextBattleEnemy==11)
	{
		tempZone=2;
		zone=2;

	}
	else if(nextBattleEnemy==21)
	{
		tempZone=3;
		zone=3;
	}
	else if(nextBattleEnemy==31)
	{
		tempZone=4;
		zone=4;
	}
	else if(nextBattleEnemy==41)
	{
		tempZone=5;
		zone=5;
	}
	else if(nextBattleEnemy==51)
	{
		tempZone=6;
		zone=6;
	}
	else if(nextBattleEnemy==61)
	{
		tempZone=7;
		zone=7;
	}
	else if(nextBattleEnemy==71)
	{
		tempZone=8;
		zone=8;
	}
	else if(nextBattleEnemy==81)
	{
		tempZone=9;
		zone=9;
	}
	else if(nextBattleEnemy==91)
	{
		tempZone=9;
		zone=9;
	}
	
}

public void boss()
{

}

public void tokenLoss(int tokensLost)
{
	tokens=tokens-tokensLost;
}
public void battle()
{
	if(nextBattleEnemy==1)
	{
		stage=1;
		enemyName="Tiny Red Square";
	}
	else if(nextBattleEnemy==2)
	{
		stage=2;
		enemyName="Very Small Red Square";
	}
	else if(nextBattleEnemy==3)
	{
		stage=3;
		enemyName="Small Red Square";

	}
	else if(nextBattleEnemy==4)
	{
		stage=4;
		enemyName="Red Square";

	}
	else if(nextBattleEnemy==5)
	{
		stage=5;
		enemyName="Big Red Square";
	}
	else if(nextBattleEnemy==6)
	{
		stage=6;
		enemyName="Very Big Red Square";
	}
	else if(nextBattleEnemy==7)
	{
		stage=7;
		enemyName="Large Red Square";
	}
	else if(nextBattleEnemy==8)
	{
		stage=8;
		enemyName="Very Large Red Square";
	}
	else if(nextBattleEnemy==9)
	{
		stage=9;
		enemyName="Enourmous Red Square";
	}
	else if(nextBattleEnemy==10)
	{
		stage=10;
		enemyName="Red Circle";
	}
	else if(nextBattleEnemy==11)
	{
		stage=1;
		enemyName="Tiny Orange Sqaure";
	}
	else if(nextBattleEnemy==12)
	{
		stage=2;
		enemyName="Very Small Orange Sqaure";
	}
	else if(nextBattleEnemy==13)
	{
		stage=3;
		enemyName="Small Orange Sqaure";
	}
	else if(nextBattleEnemy==14)
	{
		stage=4;
		enemyName="Orange Sqaure";
	}
	else if(nextBattleEnemy==15)
	{
		stage=5;
		enemyName="Big Orange Sqaure";
	}
	else if(nextBattleEnemy==16)
	{
		stage=6;
		enemyName="Very Big Orange Sqaure";
	}
	else if(nextBattleEnemy==17)
	{
		stage=7;
		enemyName="Large Orange Sqaure";
	}
	else if(nextBattleEnemy==18)
	{
		stage=8;
		enemyName="Very Large Orange Sqaure";
	}
	else if(nextBattleEnemy==19)
	{
		stage=9;
		enemyName="Enormous Orange Square";
	}
	else if(nextBattleEnemy==20)
	{
		stage=10;
		enemyName="Orange Circle";
	}
	else if(nextBattleEnemy==21)
	{
		stage=1;
		enemyName="Tiny Yellow Square";
	}
	else if(nextBattleEnemy==22)
	{
		stage=2;
		enemyName="Very Small Yellow Square";
	}
	else if(nextBattleEnemy==23)
	{
		stage=3;
		enemyName="Small Yellow Square";
	}
	else if(nextBattleEnemy==24)
	{
		stage=4;
		enemyName="Yellow Square";
	}
	else if(nextBattleEnemy==25)
	{
		stage=5;
		enemyName="Big Yellow Square";
	}
	else if(nextBattleEnemy==26)
	{
		stage=6;
		enemyName="Very Big Yellow Square";
	}
	else if(nextBattleEnemy==27)
	{
		stage=7;
		enemyName="Large Yellow Square";
	}
	else if(nextBattleEnemy==28)
	{
		stage=8;
		enemyName="Very Large Yellow Square";
	}
	else if(nextBattleEnemy==29)
	{
		stage=9;
		enemyName="Enormous Yellow Square";
	}
	else if(nextBattleEnemy==30)
	{
		stage=10;
		enemyName="Yellow Circle";
	}
	else if(nextBattleEnemy==31)
	{
		stage=1;
		enemyName="Tiny Green Square";
	}
	else if(nextBattleEnemy==32)
	{
		stage=2;
		enemyName="Very Small Green Square";
	}
	else if(nextBattleEnemy==33)
	{
		stage=3;
		enemyName="Small Green Square";
	}
	else if(nextBattleEnemy==34)
	{
		stage=4;
		enemyName="Green Square";
	}
	else if(nextBattleEnemy==35)
	{
		stage=5;
		enemyName="Big Green Square";
	}
	else if(nextBattleEnemy==36)
	{
		stage=6;
		enemyName="Very Big Green Square";
	}
	else if(nextBattleEnemy==37)
	{
		stage=7;
		enemyName="Large Green Square";
	}
	else if(nextBattleEnemy==38)
	{
		stage=8;
		enemyName="Very Large Green Square";
	}
	else if(nextBattleEnemy==39)
	{
		stage=9;
		enemyName="Enormous Green Square";
	}
	else if(nextBattleEnemy==40)
	{
		stage=10;
		enemyName="Green Circle";
	}
	else if(nextBattleEnemy==41)
	{
		stage=1;
		enemyName="Tiny Cyan Square";
	}
	else if(nextBattleEnemy==42)
	{
		stage=2;
		enemyName="Very Small Cyan Square";
	}
	else if(nextBattleEnemy==43)
	{
		stage=3;
		enemyName="Small Cyan Square";
	}
	else if(nextBattleEnemy==44)
	{
		stage=4;
		enemyName="Cyan Square";
	}
	else if(nextBattleEnemy==45)
	{
		stage=5;
		enemyName="Big Cyan Square";
	}
	else if(nextBattleEnemy==46)
	{
		stage=6;
		enemyName="Very Big Cyan Square";
	}
	else if(nextBattleEnemy==47)
	{
		stage=7;
		enemyName="Large Cyan Square";
	}
	else if(nextBattleEnemy==48)
	{
		stage=8;
		enemyName="Very Large Cyan Square";
	}
	else if(nextBattleEnemy==49)
	{
		stage=9;
		enemyName="Enormous Cyan Square";
	}
	else if(nextBattleEnemy==50)
	{
		stage=10;
		enemyName="Cyan Circle";
	}
	else if(nextBattleEnemy==51)
	{
		stage=1;
		enemyName="Tiny Blue Square";
	}
	else if(nextBattleEnemy==52)
	{
		stage=2;
		enemyName="Very Small Blue Square";
	}
	else if(nextBattleEnemy==53)
	{
		stage=3;
		enemyName="Small Blue Square";
	}
	else if(nextBattleEnemy==54)
	{
		stage=4;
		enemyName="Blue Square";
	}
	else if(nextBattleEnemy==55)
	{
		stage=5;
		enemyName="Big Blue Square";
	}
	else if(nextBattleEnemy==56)
	{
		stage=6;
		enemyName="Very Big Blue Square";
	}
	else if(nextBattleEnemy==57)
	{
		stage=7;
		enemyName="Large Blue Square";
	}
	else if(nextBattleEnemy==58)
	{
		stage=8;
		enemyName="Very Large Blue Square";
	}
	else if(nextBattleEnemy==59)
	{
		stage=9;
		enemyName="Enormous Blue Square";
	}
	else if(nextBattleEnemy==60)
	{
		stage=10;
		enemyName="Blue Circle";
	}
	else if(nextBattleEnemy==61)
	{
		stage=1;
		enemyName="Tiny White Square";
	}
	else if(nextBattleEnemy==62)
	{
		stage=2;
		enemyName="Very Small White Square";
	}
	else if(nextBattleEnemy==63)
	{
		stage=3;
		enemyName="Small White Square";
	}
	else if(nextBattleEnemy==64)
	{
		stage=4;
		enemyName="White Square";
	}
	else if(nextBattleEnemy==65)
	{
		stage=5;
		enemyName="Big White Square";
	}
	else if(nextBattleEnemy==66)
	{
		stage=6;
		enemyName="Very Big White Square";
	}
	else if(nextBattleEnemy==67)
	{
		stage=7;
		enemyName="Large White Square";
	}
	else if(nextBattleEnemy==68)
	{
		stage=8;
		enemyName="Very Large White Square";
	}
	else if(nextBattleEnemy==69)
	{
		stage=9;
		enemyName="Enormous White Square";
	}
	else if(nextBattleEnemy==70)
	{
		stage=10;
		enemyName="White Circle";
	}
	else if(nextBattleEnemy==71)
	{
		stage=1;
		enemyName="Tiny Magenta Square";
	}
	else if(nextBattleEnemy==72)
	{
		stage=2;
		enemyName="Very Small Magenta Square";
	}
	else if(nextBattleEnemy==73)
	{
		stage=3;
		enemyName="Small Magenta Square";
	}
	else if(nextBattleEnemy==74)
	{
		stage=4;
		enemyName="Magenta Square";
	}
	else if(nextBattleEnemy==75)
	{
		stage=5;
		enemyName="Big Magenta Square";
	}
	else if(nextBattleEnemy==76)
	{
		stage=6;
		enemyName="Very Big Magenta Square";
	}
	else if(nextBattleEnemy==77)
	{
		stage=7;
		enemyName="Large Magenta Square";
	}
	else if(nextBattleEnemy==78)
	{
		stage=8;
		enemyName="Very Large Magenta Square";
	}
	else if(nextBattleEnemy==79)
	{
		stage=9;
		enemyName="Enormous Magenta Square";
	}
	else if(nextBattleEnemy==80)
	{
		stage=10;
		enemyName="Magenta Circle";
	}
}
public void update(Graphics g)
{

}

public void zones()
{

}

public void exp()
{
	tempExperience=1000*enemyExperience/level;
	experience=tempExperience+experience;
	GameState=10;
	repaint();
}




public void engine()
{
	int x;
	int y;
	int z=0;
	z=manaRegen;
	if(manaRegen+tempMana>=mana)
	{
		z=mana-tempMana;
	}
	tempMana=tempMana+z;
	if(heal==true||manaAdd==true)
	{
		damage=0;
		manaAdd=false;
	}
	else if(heal==false)
	{
		y=tempDamage-enemyDefense;
		if(y<1)
		{
			y=2;
		}
		else if(y>=0)
		{
			damage=r.nextInt(tempDamage-enemyDefense);
		}
	}
	if(runTry==true && ran==false)
	{
		damage=0;
	}
	enemyTempHealth=enemyTempHealth-damage;
	x=enemyStrength-defense;
	if(x<=1)
	{
		x=2;
	}
	enemyTempDamage=r.nextInt(x);
	gageTempHealth=gageTempHealth-enemyTempDamage;
	repaint();
}

	public void mousePressed(MouseEvent arg0) {
	if((arg0.getPoint().x)>200 && arg0.getPoint().x<350 && arg0.getPoint().y<180 && arg0.getPoint().y>100 && GameState==0)
	{		
		GameState=1;
		repaint();
	}
	else if((arg0.getPoint().x)>optionLeft && arg0.getPoint().x<optionLeft+optionWidth && arg0.getPoint().y<75+optionHeight && arg0.getPoint().y>75 && GameState==1)
	{
		GameState=2;
		training=true;
		repaint();

	}
	else if((arg0.getPoint().x)>optionLeft && arg0.getPoint().x<optionLeft+optionWidth && arg0.getPoint().y<175+optionHeight && arg0.getPoint().y>175 && GameState==1)
	{
		GameState=13;
		repaint();
	}
	else if((arg0.getPoint().x)>optionLeft && arg0.getPoint().x<optionLeft+optionWidth && arg0.getPoint().y<275+optionHeight && arg0.getPoint().y>275 && GameState==1)
	{
		bossBattle=true;
		GameState=4;
		repaint();
	}
	else if((arg0.getPoint().x)>optionLeft && arg0.getPoint().x<optionLeft+optionWidth && arg0.getPoint().y<375+optionHeight && arg0.getPoint().y>375 && GameState==1)
	{
		GameState=5;
		repaint();
	}
	else if((arg0.getPoint().x)>optionRight && arg0.getPoint().x<optionRight+optionWidth && arg0.getPoint().y<75+optionHeight && arg0.getPoint().y>75 && GameState==1)
	{
		GameState=16;
		repaint();
	}		
	else if((arg0.getPoint().x)>optionRight && arg0.getPoint().x<optionRight+optionWidth && arg0.getPoint().y<175+optionHeight && arg0.getPoint().y>175 && GameState==1)
	{
		GameState=7;
		repaint();
	}		
	else if((arg0.getPoint().x)>optionRight && arg0.getPoint().x<optionRight+optionWidth && arg0.getPoint().y<275+optionHeight && arg0.getPoint().y>275 && GameState==1)
	{
		GameState=8;
		repaint();
	}		
	else if((arg0.getPoint().x)>optionRight && arg0.getPoint().x<optionRight+optionWidth && arg0.getPoint().y<375+optionHeight && arg0.getPoint().y>375 && GameState==1)
	{
		System.exit(0);
	}
	else if((arg0.getPoint().x)>optionRight && arg0.getPoint().x<optionRight+optionWidth && arg0.getPoint().y<375+optionHeight && arg0.getPoint().y>375 && GameState==5)
	{
		GameState=1;
		repaint();
	}
	//Training battle//
	else if((arg0.getPoint().x)>optionLeft && arg0.getPoint().x<optionLeft+optionWidth && arg0.getPoint().y<75+optionHeight && arg0.getPoint().y>75 && GameState==2)
	{
		GameState=3;
		trainingEnemy=1;
		start=true;
		repaint();
	}
	else if((arg0.getPoint().x)>optionLeft && arg0.getPoint().x<optionLeft+optionWidth && arg0.getPoint().y<175+optionHeight && arg0.getPoint().y>175 && GameState==2)
	{
		GameState=3;
		trainingEnemy=2;
		start=true;
		repaint();
	}
	else if((arg0.getPoint().x)>optionLeft && arg0.getPoint().x<optionLeft+optionWidth && arg0.getPoint().y<275+optionHeight && arg0.getPoint().y>275 && GameState==2)
	{
		GameState=3;
		trainingEnemy=3;
		start=true;
		repaint();
	}
	else if((arg0.getPoint().x)>optionLeft && arg0.getPoint().x<optionLeft+optionWidth && arg0.getPoint().y<375+optionHeight && arg0.getPoint().y>375 && GameState==2)
	{
		GameState=3;
		trainingEnemy=4;
		start=true;
		repaint();
	}
	else if((arg0.getPoint().x)>optionRight && arg0.getPoint().x<optionRight+optionWidth && arg0.getPoint().y<75+optionHeight && arg0.getPoint().y>75 && GameState==2)
	{
		GameState=3;
		trainingEnemy=5;
		start=true;
		repaint();
	}		
	else if((arg0.getPoint().x)>optionRight && arg0.getPoint().x<optionRight+optionWidth && arg0.getPoint().y<175+optionHeight && arg0.getPoint().y>175 && GameState==2)
	{
		GameState=3;
		trainingEnemy=6;
		start=true;
		repaint();
	}		
	else if((arg0.getPoint().x)>optionRight && arg0.getPoint().x<optionRight+optionWidth && arg0.getPoint().y<275+optionHeight && arg0.getPoint().y>275 && GameState==2)
	{
		GameState=3;
		trainingEnemy=7;
		start=true;
		repaint();
	}
	else if((arg0.getPoint().x)>optionRight && arg0.getPoint().x<optionRight+optionWidth && arg0.getPoint().y<375+optionHeight && arg0.getPoint().y>375 && GameState==2)
	{
		GameState=1;
		repaint();
	}
	else if((arg0.getPoint().x)>200 && arg0.getPoint().x<350 && arg0.getPoint().y<380 && arg0.getPoint().y>300 && GameState==0)
	{		
		System.exit(0);
	}
	else if((arg0.getPoint().x)>0 && arg0.getPoint().x<600 && arg0.getPoint().y<500 && arg0.getPoint().y>0 && GameState==8)
	{		
		GameState=1;
		repaint();
	}
	else if((arg0.getPoint().x)>230 && arg0.getPoint().x<300 && arg0.getPoint().y<490 && arg0.getPoint().y>450 && GameState==3)
	{	
		moveState=1;
		damage=strength;
		tempDamage=damage;
		engine();
	}
	else if((arg0.getPoint().x)>300 && arg0.getPoint().x<370 && arg0.getPoint().y<490 && arg0.getPoint().y>450 && GameState==3)
	{	
		if(tempMana-1000>=0)
		{
			moveState=2;
			tempMana=tempMana-1000;

			tempDamage=strength*2;
			engine();
		}
		else if(tempMana-1000<0)
		{
			noMana=true;
			repaint();
		}
	}
	else if((arg0.getPoint().x)>370 && arg0.getPoint().x<440 && arg0.getPoint().y<490 && arg0.getPoint().y>450 && GameState==3)
	{	
		int x=0;
		manaAdd=true;
		moveState=3;
		x=500;
		if(tempMana+500>=mana)
		{
			x=mana-tempMana;
		}
		tempMana=tempMana+x;
		engine();
	}
	else if((arg0.getPoint().x)>440 && arg0.getPoint().x<510 && arg0.getPoint().y<490 && arg0.getPoint().y>450 && GameState==3)
	{	
		if(level>=50)
		{
			lv50=true;
			moveState=4;
			tempDamage=tempMana;
			tempMana=tempMana-tempMana;	
			engine();
		}
		else if(level<50)
		{
			lv50=false;
			GameState=3;
			repaint();
		}
		manaBurst=true;

	}
	else if((arg0.getPoint().x)>510 && arg0.getPoint().x<580 && arg0.getPoint().y<490 && arg0.getPoint().y>450 && GameState==3)
	{	
		if(tempMana<500)
		{
			noMana=true;
			GameState=3;
			repaint();
		}
		else if(tempMana>=500)
		{
			tempMana=tempMana-500;
			heal=true;
			moveState=5;
			engine();
		}
	}else if((arg0.getPoint().x)>500 && arg0.getPoint().x<570 && arg0.getPoint().y<50 && arg0.getPoint().y>10 && GameState==3)
	{	
		int x=r.nextInt(5);
		ran=false;
		runTry=true;
		if(x==1)
		{

			ran=true;
			engine();
		}
		else 
		{
			ran=false;
			engine();
		}

	}
	else if((arg0.getPoint().x)>0 && arg0.getPoint().x<600 && arg0.getPoint().y<500 && arg0.getPoint().y>0 && GameState==10 && levelUp==true)
	{		
		GameState=11;
		repaint();
	}
	else if((arg0.getPoint().x)>0 && arg0.getPoint().x<600 && arg0.getPoint().y<500 && arg0.getPoint().y>0 && GameState==10 && levelUp==false)
	{		
		GameState=9;
		repaint();
	}

	else if((arg0.getPoint().x)>200 && arg0.getPoint().x<300 && arg0.getPoint().y<170 && arg0.getPoint().y>100 && GameState==11)
	{

		GameState=9;
		Gain=true;
		strengthGain=true;
		repaint();
	}
	else if((arg0.getPoint().x)>200 && arg0.getPoint().x<300 && arg0.getPoint().y<270 && arg0.getPoint().y>200 && GameState==11)
	{

		GameState=9;
		Gain=true;
		healthGain=true;
		repaint();
	}
	else if((arg0.getPoint().x)>200 && arg0.getPoint().x<300 && arg0.getPoint().y<370 && arg0.getPoint().y>300 && GameState==11)
	{

		GameState=9;
		Gain=true;
		manaGain=true;
		repaint();
	}
	else if((arg0.getPoint().x)>200 && arg0.getPoint().x<300 && arg0.getPoint().y<470 && arg0.getPoint().y>400 && GameState==11)
	{		
		Gain=true;
		manaRegenGain=true;
		GameState=9;
		repaint();
	}
	else if((arg0.getPoint().x)>0 && arg0.getPoint().x<600 && arg0.getPoint().y<500 && arg0.getPoint().y>0 && GameState==9)
	{		
		GameState=15;
		repaint();
	}
	else if((arg0.getPoint().x)>0 && arg0.getPoint().x<600 && arg0.getPoint().y<500 && arg0.getPoint().y>0 && GameState==12)
	{		
		GameState=1;
		repaint();
	}
	else if((arg0.getPoint().x)>0 && arg0.getPoint().x<600 && arg0.getPoint().y<500 && arg0.getPoint().y>0 && GameState==13)
	{		
		start=true;
		nextBattle=true;
		GameState=3;
		repaint();
	}
	else if((arg0.getPoint().x)>0 && arg0.getPoint().x<600 && arg0.getPoint().y<500 && arg0.getPoint().y>0 && GameState==15)
	{
		GameState=1;
		repaint();
	}
	//Boss Battles
	else if((arg0.getPoint().x)>optionLeft && arg0.getPoint().x<optionLeft+optionWidth && arg0.getPoint().y<75+optionHeight && arg0.getPoint().y>75 && GameState==4)
	{
		start=true;
		bossBattleEnemy=1;
		GameState=3;
		repaint();
	}
	else if((arg0.getPoint().x)>optionLeft && arg0.getPoint().x<optionLeft+optionWidth && arg0.getPoint().y<175+optionHeight && arg0.getPoint().y>175 && GameState==4)
	{
		if(zone>=2)
		{
			start=true;
			bossBattleEnemy=2;
			GameState=3;
			repaint();
		}
		else
		{
			bossZoneReq=2;
			bossZone=true;
			GameState=4;
			repaint();
		}
	}
	else if((arg0.getPoint().x)>optionLeft && arg0.getPoint().x<optionLeft+optionWidth && arg0.getPoint().y<275+optionHeight && arg0.getPoint().y>275 && GameState==4)
	{
		if(zone>=3)
		{
			start=true;
			bossBattleEnemy=3;
			GameState=3;
			repaint();
		}
		else
		{
			bossZoneReq=3;
			bossZone=true;
			GameState=4;
			repaint();
		}
	}
	else if((arg0.getPoint().x)>optionLeft && arg0.getPoint().x<optionLeft+optionWidth && arg0.getPoint().y<375+optionHeight && arg0.getPoint().y>375 && GameState==4)
	{
		if(zone>=4)
		{
			start=true;
			bossBattleEnemy=4;
			GameState=3;
			repaint();
		}
		else
		{
			bossZoneReq=4;
			bossZone=true;
			GameState=4;
			repaint();
		}
	}
	else if((arg0.getPoint().x)>optionRight && arg0.getPoint().x<optionRight+optionWidth && arg0.getPoint().y<75+optionHeight && arg0.getPoint().y>75 && GameState==4)
	{
		if(zone>=5)
		{
			start=true;
			bossBattleEnemy=5;
			GameState=3;
			repaint();
		}
		else
		{
			bossZoneReq=5;
			bossZone=true;
			GameState=4;
			repaint();
		}
	}		

	else if((arg0.getPoint().x)>optionRight && arg0.getPoint().x<optionRight+optionWidth && arg0.getPoint().y<175+optionHeight && arg0.getPoint().y>175 && GameState==4)
	{
		if(zone>=6)
		{
			start=true;
			bossBattleEnemy=6;
			GameState=3;
			repaint();
		}
		else
		{
			bossZoneReq=6;
			bossZone=true;
			GameState=4;
			repaint();
		}
	}		
	else if((arg0.getPoint().x)>optionRight && arg0.getPoint().x<optionRight+optionWidth && arg0.getPoint().y<275+optionHeight && arg0.getPoint().y>275 && GameState==4)
	{
		if(zone>=7)
		{
			GameState=17;
			repaint();
		}
		else
		{
			bossZoneReq=7;
			bossZone=true;
			GameState=4;
			repaint();
		}
	}

	else if((arg0.getPoint().x)>optionRight && arg0.getPoint().x<optionRight+optionWidth && arg0.getPoint().y<375+optionHeight && arg0.getPoint().y>375 && GameState==4)
	{
		GameState=1;
		repaint();
	}

	//Shop Screen//
	else if((arg0.getPoint().x)>optionLeft && arg0.getPoint().x<optionLeft+optionWidth && arg0.getPoint().y<75+optionHeight && arg0.getPoint().y>75 && GameState==16)
	{
		if(tokens<10)
		{
			noTokens=true;
			GameState=16;
			repaint();
		}
		else if(tokens>=10)
		{
			tokens=tokens-10;
			buyItem=1;
			GameState=18;
			repaint();
		}

	}
	else if((arg0.getPoint().x)>optionLeft && arg0.getPoint().x<optionLeft+optionWidth && arg0.getPoint().y<175+optionHeight && arg0.getPoint().y>175 && GameState==16)
	{
		if(tokens<10)
		{
			noTokens=true;
			GameState=16;
			repaint();
		}
		else if(tokens>=10)
		{
			tokens=tokens-10;
			buyItem=2;
			GameState=18;
			repaint();
		}
	}
	else if((arg0.getPoint().x)>optionLeft && arg0.getPoint().x<optionLeft+optionWidth && arg0.getPoint().y<275+optionHeight && arg0.getPoint().y>275 && GameState==16)
	{
		if(tokens<10)
		{
			noTokens=true;
			GameState=16;
			repaint();
		}
		else if(tokens>=10)
		{
			tokens=tokens-10;
			buyItem=3;
			GameState=18;
			repaint();
		}
	}
	else if((arg0.getPoint().x)>optionLeft && arg0.getPoint().x<optionLeft+optionWidth && arg0.getPoint().y<375+optionHeight && arg0.getPoint().y>375 && GameState==16)
	{
		if(tokens<10)
		{
			noTokens=true;
			GameState=16;
			repaint();
		}
		else if(tokens>=10)
		{
			tokens=tokens-10;
			buyItem=4;
			GameState=18;
			repaint();
		}
	}
	else if((arg0.getPoint().x)>optionRight && arg0.getPoint().x<optionRight+optionWidth && arg0.getPoint().y<75+optionHeight && arg0.getPoint().y>75 && GameState==16)
	{
		if(tokens<10)
		{
			noTokens=true;
			GameState=16;
			repaint();
		}
		else if(tokens>=10)
		{
			tokens=tokens-10;
			buyItem=5;
			GameState=18;
			repaint();
		}
	}		
	else if((arg0.getPoint().x)>optionRight && arg0.getPoint().x<optionRight+optionWidth && arg0.getPoint().y<175+optionHeight && arg0.getPoint().y>175 && GameState==16)
	{
		if(tokens<20)
		{
			noTokens=true;
			GameState=16;
			repaint();
		}
		else if(tokens>=10)
		{
			tokens=tokens-10;
			buyItem=6;
			GameState=18;
			repaint();
		}
	}		
	else if((arg0.getPoint().x)>optionRight && arg0.getPoint().x<optionRight+optionWidth && arg0.getPoint().y<275+optionHeight && arg0.getPoint().y>275 && GameState==16)
	{
		if(tokens<20)
		{
			noTokens=true;
			GameState=16;
			repaint();
		}
		else if(tokens>=20)
		{
			tokens=tokens-20;
			buyItem=7;
			GameState=18;
			repaint();
		}
	}		
	else if((arg0.getPoint().x)>optionRight && arg0.getPoint().x<optionRight+optionWidth && arg0.getPoint().y<375+optionHeight && arg0.getPoint().y>375 && GameState==16)
	{
		GameState=1;
		repaint();
	}
	else if((arg0.getPoint().x)>0 && arg0.getPoint().x<600 && arg0.getPoint().y<500 && arg0.getPoint().y>0 && GameState==18)
	{		
		GameState=1;
		repaint();
	}
	//zone graphics//
	else if((arg0.getPoint().x)>optionLeft && arg0.getPoint().x<optionLeft+optionWidth && arg0.getPoint().y<75+optionHeight && arg0.getPoint().y>75 && GameState==5)
	{
		GameState=17;
		repaint();

	}
	else if((arg0.getPoint().x)>optionLeft && arg0.getPoint().x<optionLeft+optionWidth && arg0.getPoint().y<175+optionHeight && arg0.getPoint().y>175 && GameState==5)
	{
		GameState=17;
		repaint();
	}
	else if((arg0.getPoint().x)>optionLeft && arg0.getPoint().x<optionLeft+optionWidth && arg0.getPoint().y<275+optionHeight && arg0.getPoint().y>275 && GameState==5)
	{
		GameState=17;
		repaint();
	}
	else if((arg0.getPoint().x)>optionLeft && arg0.getPoint().x<optionLeft+optionWidth && arg0.getPoint().y<375+optionHeight && arg0.getPoint().y>375 && GameState==5)
	{
		GameState=17;
		repaint();
	}
	else if((arg0.getPoint().x)>optionRight && arg0.getPoint().x<optionRight+optionWidth && arg0.getPoint().y<75+optionHeight && arg0.getPoint().y>75 && GameState==5)
	{
		GameState=17;
		repaint();
	}		
	else if((arg0.getPoint().x)>optionRight && arg0.getPoint().x<optionRight+optionWidth && arg0.getPoint().y<175+optionHeight && arg0.getPoint().y>175 && GameState==5)
	{
		GameState=17;
		repaint();
	}		
	else if((arg0.getPoint().x)>optionRight && arg0.getPoint().x<optionRight+optionWidth && arg0.getPoint().y<275+optionHeight && arg0.getPoint().y>275 && GameState==5)
	{
		GameState=17;
		repaint();
	}		
	else if((arg0.getPoint().x)>optionRight && arg0.getPoint().x<optionRight+optionWidth && arg0.getPoint().y<375+optionHeight && arg0.getPoint().y>375 && GameState==5)
	{
		GameState=1;
		repaint();
	}

	//extra graphics//
	else if((arg0.getPoint().x)>optionLeft && arg0.getPoint().x<optionLeft+optionWidth && arg0.getPoint().y<75+optionHeight && arg0.getPoint().y>75 && GameState==7)
	{
		GameState=17;
		repaint();

	}
	else if((arg0.getPoint().x)>optionLeft && arg0.getPoint().x<optionLeft+optionWidth && arg0.getPoint().y<175+optionHeight && arg0.getPoint().y>175 && GameState==7)
	{
		GameState=6;
		repaint();
	}
	else if((arg0.getPoint().x)>optionLeft && arg0.getPoint().x<optionLeft+optionWidth && arg0.getPoint().y<275+optionHeight && arg0.getPoint().y>275 && GameState==5)
	{
		GameState=17;
		repaint();
	}
	else if((arg0.getPoint().x)>optionLeft && arg0.getPoint().x<optionLeft+optionWidth && arg0.getPoint().y<375+optionHeight && arg0.getPoint().y>375 && GameState==5)
	{
		GameState=17;
		repaint();
	}
	else if((arg0.getPoint().x)>optionRight && arg0.getPoint().x<optionRight+optionWidth && arg0.getPoint().y<75+optionHeight && arg0.getPoint().y>75 && GameState==5)
	{
		GameState=17;
		repaint();
	}		
	else if((arg0.getPoint().x)>optionRight && arg0.getPoint().x<optionRight+optionWidth && arg0.getPoint().y<175+optionHeight && arg0.getPoint().y>175 && GameState==5)
	{
		GameState=17;
		repaint();
	}		
	else if((arg0.getPoint().x)>optionRight && arg0.getPoint().x<optionRight+optionWidth && arg0.getPoint().y<275+optionHeight && arg0.getPoint().y>275 && GameState==5)
	{
		GameState=17;
		repaint();
	}		
	else if((arg0.getPoint().x)>optionRight && arg0.getPoint().x<optionRight+optionWidth && arg0.getPoint().y<375+optionHeight && arg0.getPoint().y>375 && GameState==5)
	{
		GameState=1;
		repaint();
	}

	else if((arg0.getPoint().x)>0 && arg0.getPoint().x<600 && arg0.getPoint().y<500 && arg0.getPoint().y>0 && GameState==6)
	{
		GameState=1;
		repaint();
	}



	else if((arg0.getPoint().x)>0 && arg0.getPoint().x<600 && arg0.getPoint().y<500 && arg0.getPoint().y>0 && GameState==17)
	{		
		GameState=1;
		repaint();
	}



}
public void mouseClicked(MouseEvent arg1) 
{


}
public void mouseEntered(MouseEvent arg2) {


}

public void mouseExited(MouseEvent arg3) {

}



public void mouseReleased(MouseEvent arg4) {


}
}