package com.TestWeb.Board.model;

public class PageVO {
	
	private int start;			//시작번호
	private int end;			//끝번호
	
	private int page;			//현재 페이지
	private int pageAmount;		//표시 페이지 수
	
	private int totalContent; 	//총 컨텐츠 수
	private int totalPage;		//총 페이지 수
	private int contentAmount;	//페이지당 게시글 표기 수량
	
	private boolean prev;		//페이지 이전 이동 표기여부
	private boolean next;		//페이지 이후 이동 표기여부
	
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
