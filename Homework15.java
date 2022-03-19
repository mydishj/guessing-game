package Chapter07.exercises;

import java.util.Scanner;

public class Homework15 {
	//有个人 Tom 设计它的成员变量,成员方法,可以电脑猜拳,电脑每次都会随机生成 0，1，2

	//0表示 石头 1表示剪刀 2表示布
	//并要可以显示 Tom的输赢次数
	//分析
	//1.创建出用户类 User 方法GetName 名称 SetName 名字 GetScore 分数
	//2.创建人机类 Computer 方法GetName 名称 SetName 名字 GetScore 分数 RandNums 随机数(出拳)
	//3.主方法
	//1).创建 Scanner 键盘扫描对象
	//2).使用 switch 定义角色
	//3).使用while 循环比较字符串是否为 y   使用if 判断出拳   if else if if 判断结果
	//4).输出结果
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);//创建一个键盘扫描对象
		User user = new User();//用户
		Computer computer = new Computer();//计算机/人机
		int vsNums = 0; // 对战次数
		int draw = 0;
		System.out.println("出拳游戏规则：0,剪刀，1,石头，2,布");
		System.out.println("=======================================");
		System.out.println("请选择对方角色(1.刘备,2.孙权,3.曹操,4.Tom)");
		int n = input.nextInt();//输入整型(编号)
		switch (n){//定义角色
			case 1:
				computer.SetName("刘备");
				break;
			case 2:
				computer.SetName("孙权");
				break;
			case 3:
				computer.SetName("曹操");
				break;
			case 4:
				computer.SetName("Tom");
				break;
		}
		//System.out.println("请输入你的名字");
		String name = "Tom"; //input.next(); //选角色
		System.out.println("我的名字是" + name);
		user.SetName(name);//使用的角色
		System.out.println(user.GetName() + "vs" + computer.GetName());// pk
		String flag = "y";
		while (flag.equals(flag)){//比较字符串 是否为 yes
			System.out.println("开始吗？ 输入y");
			String yrn = input.next();//输入字符串类型
			if (yrn.equals("y")){
				vsNums++;
				System.out.println("请出拳：0、剪刀，1、石头，2、布(输入数字)");
				int num = input.nextInt();//输入整型(编号)
				switch (num){
					case 0:
						System.out.println("你出拳："+"剪刀");
						break;
					case 1:
						System.out.println("你出拳："+"石头");
						break;
					case 2:
						System.out.println("你出拳："+"布");
						break;
				}
				int rand = computer.RandNums();
				switch (rand){
					case 0:
						System.out.println(computer.GetName() + "你出拳："+"剪刀");
						break;
					case 1:
						System.out.println(computer.GetName() +"你出拳："+"石头");
						break;
					case 2:
						System.out.println(computer.GetName() +"你出拳："+"布");
						break;
				}
				//判断
				if (num == 1 && rand == 3 || num == 2 && rand == 1 || num == 3 && rand == 2){
					System.out.println("你赢了");
					user.SetScore(1);
				}else if (num == rand){
					System.out.println("平手");
					draw++;
				}else{
					System.out.println("你输了");
					computer.SetScore(1);
				}
			}
			else {
				System.out.println(computer.GetName() + "VS" + user.GetName());
				System.out.println("对战次数" + vsNums);
				System.out.println("姓名\t得分");
				System.out.println(user.GetName()+"\t"+user.GetScore());
				System.out.println(computer.GetName()+"\t"+computer.GetScore());
				System.out.println("平局" + draw + "次");
				if (user.GetScore() > computer.GetScore()){
					System.out.println("你已赢过" + computer.GetName());
				}else {
					System.out.println("你败在" + computer.GetName());
				}
				break;
			}
		}
	}
}
//用户类
class User{
	public String name;
	public int score = 0;
	public int num;
	public String GetName(){
		return this.name;
	}
	public void SetName(String name){
		this.name = name;
	}
	public int GetScore(){
		return this.score;
	}
	public void SetScore(int score){
		this.score += score;
	}
}
//人机类
class Computer {
	public String name;
	public int score = 0;
	public int num;
	public String GetName() {
		return this.name;
	}
	public void SetName(String name) {
		this.name = name;
	}
	public int RandNums() {
		int n;
		n = (int) (Math.random() * 3);
		return n;
	}
	public int GetScore() {
		return this.score;
	}
	public void SetScore(int score) {
		this.score += score;
	}
}
