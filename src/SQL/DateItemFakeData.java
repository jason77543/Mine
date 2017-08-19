package SQL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.restaurant.model.Restaurant;
import com.restaurant.model.RestaurantJDBCDAO;
import com.restaurant.model.RestaurantService;

public class DateItemFakeData {
	
	
	
	public static void main(String[] args){
		
		Map<Integer,Integer> pMember=new HashMap<Integer,Integer>();
		for(int i=5001;i<=5015;i++){
			for(int j=0;j<3;j++){
			pMember.put(i, i-4000+j);
			}
		}

		RestaurantJDBCDAO restDao=new RestaurantJDBCDAO();
		Map<Integer,String> rest=new HashMap<Integer,String>();
		for(int i=7006;i<=7080;i++){
			String loc=restDao.findByPK(i).getRestLocate();
			rest.put(i, loc);
		}
		
		List<String> dText=new ArrayList<String>();
		dText.add("Hey�� �˷R���A�̡A�̪�n���� �n�@�}�l�S����A�̳ܪM�@�ءB�U�ȯ��F�C��۳o���R���I�R�A�N�o�˧ڭ̶}�l�F���n���@�ѱ����C�C���h�A�N���F�o�f���H�n�F�A�ѫG�F�A�ڭ̥i�H�ɱ������A�F�C");
		dText.add("Hi~�̪�Ѯ�S�O�n�A�b�o���n���Ѯ�� �̾A�X��n�B�͡A�p�G�A�@�N���ڤ@�_�Y�y���A�|�O�b�������L���@�ѤF");
		dText.add("���o���A�j�a�n�ڡA�ڳ̪�W�R�ݤ��꦳�H�����A�γ\�ڭ̥i�H��Y����ᤤ�꦳�H���᪺�A");
		dText.add("�A�b�ݧڶܡA�S���N�O�p�A�٤��֨ӦY����ӪB�͡A�ڮa�i�R���d�����b���ۧA�O");
		dText.add("�ڮa���d���̪�ܩt��O�A�o���b���ۧA��A���}");
		dText.add("�ڳ̪�b�Чڮa�����ǲ�Hibernate�A�o�w�g�}�l�|�زպA�פF�A�γ\�ڭ̥i�H��Y�����Java��");
		
		
		List<String> dTitle=new ArrayList<String>();
		dTitle.add("�ڭ��ۭ��ۻ��S�ƧA���N�۫H�F�O");
		dTitle.add("�֨Ӥ@�_���a");
		dTitle.add("Yo this is your best chance");
		dTitle.add("�Ѯ�W�n�� ���Ѥ@�_�Y�Ӷ��a");
		dTitle.add("�ڷQ�p�F�A�A�̴H�N���Ѯ��");
		
		List<String> dDate=new ArrayList<String>();
		dDate.add("20170820");
		dDate.add("20170821");
		dDate.add("20170815");

		List<String> mDate=new ArrayList<String>();
		mDate.add("20170830");
		mDate.add("20170825");
		mDate.add("20170822");
		
		List<String> time=new ArrayList<String>();
		time.add("20:30:20");
		time.add("12:30:20");
		time.add("09:30:20");
		
		
		
		Random rand = new Random();
		for(int i=0;i<100;i++){
			Integer pMemberRand=rand.nextInt(pMember.size())+1;
			Integer restRand=rand.nextInt(rest.size())+1;
			Integer title=rand.nextInt(dTitle.size())+1;
		
			String sql="INSERT INTO DATEITEM values (DATEITEMNO_SQ.NEXTVAL,"+(pMemberRand).toString()+","+restRand+",\'"+dTitle.get(title)+"\'";
			System.out.println(sql); 
			
		}
		
		
		
		
	}
}
