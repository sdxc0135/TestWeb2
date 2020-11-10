package com.TestWeb.Board.model;

public class PageVO {
	
	private int start;			//���۹�ȣ
	private int end;			//����ȣ
	
	private int page;			//���� ������
	private int pageAmount;		//ǥ�� ������ ��
	
	private int totalContent; 	//�� ������ ��
	private int totalPage;		//�� ������ ��
	private int contentAmount;	//�������� �Խñ� ǥ�� ����
	
	private boolean prev;		//������ ���� �̵� ǥ�⿩��
	private boolean next;		//������ ���� �̵� ǥ�⿩��
	
	public PageVO(int page, int contentAmount, int totalContent, int pageAmount) {
		
		this.contentAmount = contentAmount;
		this.totalContent = totalContent;
		this.pageAmount = pageAmount;
		
		this.page = page;
		this.totalPage = (int)Math.ceil(totalContent/(double)contentAmount);
						
		this.end = ((int)Math.ceil(page/(double)pageAmount))*pageAmount;
		this.start = end - pageAmount + 1;
		
		if(this.end > totalPage) {
			this.end = totalPage;
		}
		
		this.prev = this.start > 1;
		this.next =  this.totalPage > this.end;
	}

	
	@Override
	public String toString() {
		return "PageVO [start=" + start + ", end=" + end + ", page=" + page + ", pageAmount=" + pageAmount
				+ ", totalContent=" + totalContent + ", totalPage=" + totalPage + ", contentAmount=" + contentAmount
				+ ", prev=" + prev + ", next=" + next + "]";
	}


	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public int getPage() {
		return page;
	}

	public int getPageAmount() {
		return pageAmount;
	}

	public int getTotalContent() {
		return totalContent;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getContentAmount() {
		return contentAmount;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}
	
	
}
