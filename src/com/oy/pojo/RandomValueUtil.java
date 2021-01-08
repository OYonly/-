package com.oy.pojo;
import java.util.Random;

import com.oy.dao.Dao;

public class RandomValueUtil {

    public static String base = "abcdefghijklmnopqrstuvwxyz0123456789";     
    private static String firstName="��Ǯ��������֣��������������������������ʩ�ſײ��ϻ���κ�ս���л������ˮ��������˸��ɷ�����³Τ������ﻨ������Ԭ��ۺ��ʷ�Ʒ����Ѧ�׺����������ޱϺ�����������ʱ��Ƥ���뿵����Ԫ������ƽ�ƺ�������Ҧ��տ����ë����ױ���갼Ʒ��ɴ�̸��é���ܼ�������ף������������ϯ����ǿ��·¦Σ��ͯ�չ�÷ʢ�ֵ�����������Ĳ��﷮���������֧�¾̹�¬Ī�������Ѹɽ�Ӧ�������ڵ��������������ʯ�޼�ť�������ϻ���½��������춻���κ�ӷ����ഢ���������ɾ��θ����ڽ��͹�����ɽ�ȳ������ȫۭ�����������������ﱩ�����������������ղ����Ҷ��˾��۬�輻��ӡ�ް׻���̨�Ӷ����̼���׿�����ɳ����������ܲ�˫��ݷ����̷�����̼������Ƚ��۪Ӻȴ�ɣ���ţ��ͨ�����༽ۣ����ũ�±�ׯ�̲����ֳ�Ľ����ϰ����������������θ����߾Ӻⲽ�����������Ŀܹ�»�ڶ�Ź�����εԽ��¡ʦ�����˹��������������Ǽ��Ŀ���ɳؿ������ᳲ�������󽭺�����Ȩ�ָ��滸����ٹ˾���Ϲ�ŷ���ĺ�������˶��������ʸ�ξ�ٹ����̨��ұ���������������̫������������������������Ľ����������˾ͽ˾������˾���붽�ӳ�����ľ����������������ṫ���ذμй��׸����������ַ���۳Ϳ�նθɰ��ﶫ�����ź��ӹ麣����΢����˧�ÿ�������������������������Ĳ��٦�����Ϲ�ī�����갮��١��";    
    private static String girl="���Ӣ���������Ⱦ���������֥��Ƽ�����ҷ���ʴ��������÷���������滷ѩ�ٰ���ϼ����ݺ�����𷲼Ѽ�������������Ҷ�������������ɺɯ������ٻ�������ӱ¶������������Ǻɵ���ü������ޱݼ���Է�ܰ�������԰��ӽ�������ع���ѱ�ˬ������ϣ����Ʈ�����������������������ܿ�ƺ������˿ɼ���Ӱ��֦˼�� ";    
    public static String boy="ΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ�����ŷ纽��";    
    public static final String[] email_suffix="@gmail.com,@yahoo.com,@msn.com,@hotmail.com,@aol.com,@ask.com,@live.com,@qq.com,@0355.net,@163.com,@163.net,@263.net,@3721.net,@yeah.net,@googlemail.com,@126.com,@sina.com,@sohu.com,@yahoo.com.cn".split(",");    

    public static int getNum(int start,int end) {    
        return (int)(Math.random()*(end-start+1)+start);    
    }    

    /*�������Email*/
    public static String getEmail(int lMin,int lMax) {    
        int length=getNum(lMin,lMax);    
        StringBuffer sb = new StringBuffer();         
        for (int i = 0; i < length; i++) {         
            int number = (int)(Math.random()*base.length());    
            sb.append(base.charAt(number));         
        }    
        sb.append(email_suffix[(int)(Math.random()*email_suffix.length)]);    
        return sb.toString();       
    }    

    private static String[] telFirst="134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");    

    /*��������ֻ�����*/
    public static String getTelephone() {    
        int index=getNum(0,telFirst.length-1);    
        String first=telFirst[index];    
        String second=String.valueOf(getNum(1,888)+10000).substring(1);    
        String thrid=String.valueOf(getNum(1,9100)+10000).substring(1);    
        return first+second+thrid;    
    }    



    /* ������������  */    
    public static String name_sex = "";    
   
  public static String getChineseName() {
      int index = getNum(0, firstName.length() - 1);
      String first = firstName.substring(index, index + 1);
      int sex = getNum(0, 1);
      String str = boy;
      int length = boy.length();
      if (sex == 0) {
          str = girl;
          length = girl.length();
          name_sex = "Ů";
      } else {
          name_sex = "��";
      }
      index = getNum(0, length - 1);
      String second = str.substring(index, index + 1);
      int hasThird = getNum(0, 1);
      String third = "";
      if (hasThird == 1) {
          index = getNum(0, length - 1);
          third = str.substring(index, index + 1);
      }
      return first + second + third;
  }    
  
   public static String getSex() {
      int randNum = new Random().nextInt(2) + 1;
      return randNum == 1 ? "��" : "Ů";
  }
  
	public static void main(String[] args) {
		final Dao user=new Dao();
		/*for(int i=1;i<10001;i++) {
			user.addUserInfo("2020"+i,
					new RandomValueUtil().getChineseName(),
					new RandomValueUtil().getNum(10,60),
					new RandomValueUtil().getSex(),
					new RandomValueUtil().getTelephone(),
					new RandomValueUtil().getEmail(9,12)
					);
			}*/
		}

}
