package lsy.datastructure;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample {

	public static void main(String[] args) {
		
		//linkedList의 각 요소 노드들은 자신과 연결된 다음요소에 대한 참조(주소값)와 데이터로 구성되어있다.
		
		//선언방법
		LinkedList list = new LinkedList();//타입을 설정안하면 objects
		LinkedList<Integer> num = new LinkedList<Integer>();//타입설정 int타입만 사용가능
		LinkedList<Integer> num2 = new LinkedList<>();//new에서 타입 파라미터 생략가능
		LinkedList<Integer> list2 = new LinkedList<Integer>(Arrays.asList(1,2));//생성시 값추가
		
		//Arrays.asList란 Arrays.asList()는 Arrays의 private 정적 클래스인 ArrayList를 리턴한다.
		//java.util.ArrayList 클래스와는 다른 클래스이다.
		//java.util.Arrays.ArrayList 클래스는 set(), get(), contains() 메서드를 가지고 있지만
		//원소를 추가하는 메서드는 가지고 있지 않기 때문에 사이즈를 바꿀 수 없다.
		//Arrays.asList()는 배열의 내용을 수정하려고 할 때 List로 바꿔서 편리하게 사용하기 위함.
		
		
		//값 추가
		list.addFirst(1);//가장 앞에 데이터 추가
		list.addLast(2);//가장 뒤에 데이터 추가
		list.add(3);//데이터 추가
		list.add(1, 10);//index 1에 데이터 10 추가
		
		//LinkedList에 값을 추가하는 방법은 여러 개가 있는데 대중적으로 add(index, value) 메소드를 사용합니다. 
		//index를 생략하면 가장 마지막에 데이터가 추가됩니다. 
		
		
		//삭제처리
		LinkedList<Integer> list3 = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5));
		list3.removeFirst(); //가장 앞의 데이터 제거
		list3.removeLast(); //가장 뒤의 데이터 제거
		list3.remove(); //생략시 0번째 index제거
		list3.remove(1); //index 1 제거
		list3.clear(); //모든 값 제거
		
		
		//크기 구하기
		LinkedList<Integer> list4 = new LinkedList<Integer>(Arrays.asList(1,2,3));
		System.out.println("list4 : " + list4.size()); //list 크기 : 3
		
		
		
		//값 구하기
		LinkedList<Integer> list5 = new LinkedList<Integer>(Arrays.asList(1,2,3));

		System.out.println("list5 : " + list5.get(0));//0번째 index 출력
						
		for(Integer i : list5) { //for문을 통한 전체출력
		    System.out.println("list5 : " + i);
		}

		Iterator<Integer> iter = list5.iterator(); //Iterator 선언  > 저장되어 있는 요소들을 읽어오는 방법을 표준화 한것
		while(iter.hasNext()){//다음값이 있는지 체크
		    System.out.println("list5 : " + iter.next()); //값 출력
		}
		
		
		
		//값 검색
		LinkedList<Integer> list6 = new LinkedList<Integer>(Arrays.asList(1,2,3));
		System.out.println("list6 : " + list6.contains(1)); //list에 1이 있는지 검색 : true
		System.out.println("list6 : " + list6.indexOf(1)); //1이 있는 index반환 없으면 -1
		
		//LinkedList에서 찾고자 하는 값을 검색하려면 LinkedList의 contains(value) 메소드를 사용하면 됩니다. 
		//만약 값이 있다면 true가 리턴되고 값이 없다면 false가 리턴됩니다. 
		//값을 있는 index를 찾으려면 indexOf(value) 메소드를 사용하면 되고 만약 값이 없다면 -1을 리턴합니다.
		
		
	}

}
