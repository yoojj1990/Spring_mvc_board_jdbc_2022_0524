package com.yjj.MVCBoard.dto;

import java.sql.Timestamp;

public class BDto {

	int bid; // 게시판 번호(기본값)
	String bname; // 글쓴사람 이름
	String btitle; // 게시글 제목
	String bcontent; // 게시글 내용
	Timestamp bdate; // 게시글 쓴 날자 및 시간
	int bhit; // 조회수
	int bgroup; // 덧글 그룹
	int bstep; // 덧글 스텝
	int bindent; // 덧글 들여쓰기
	
	public BDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BDto(int bid, String bname, String btitle, String bcontent, Timestamp bdate, int bhit, int bgroup, int bstep,
			int bindent) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bdate = bdate;
		this.bhit = bhit;
		this.bgroup = bgroup;
		this.bstep = bstep;
		this.bindent = bindent;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public Timestamp getBdate() {
		return bdate;
	}

	public void setBdate(Timestamp bdate) {
		this.bdate = bdate;
	}

	public int getBhit() {
		return bhit;
	}

	public void setBhit(int bhit) {
		this.bhit = bhit;
	}

	public int getBgroup() {
		return bgroup;
	}

	public void setBgroup(int bgroup) {
		this.bgroup = bgroup;
	}

	public int getBstep() {
		return bstep;
	}

	public void setBstep(int bstep) {
		this.bstep = bstep;
	}

	public int getBindent() {
		return bindent;
	}

	public void setBindent(int bindent) {
		this.bindent = bindent;
	}
	
	
	
}
