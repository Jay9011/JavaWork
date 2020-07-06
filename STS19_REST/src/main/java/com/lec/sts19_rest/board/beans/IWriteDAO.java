package com.lec.sts19_rest.board.beans;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

// 사용할 쿼리들을 정의
@MapperScan
public interface IWriteDAO {
	/**
	 * 원래 pstmt (preparedStatement) 로 만든 쿼리문에
	 * ? 에 값을 넣어주는 대신
	 * 매개변수로 값을 넣어준다.
	 * 리턴타입으로 DB Row 들을 알아서 변환시켜 가져와준다.
	 */
	public ArrayList<BWriteDTO> select();
	public ArrayList<BWriteDTO> selectFromRow(int fromRow, int pageRows);
	public int countAll();
	public int insert(final BWriteDTO dto);
	public int insert(String subject, String content, String name);
//	public BWriteDTO readByUid(final int uid);
	public BWriteDTO selectByUid(final int uid);
//	public int update(final BWriteDTO dto);
	public int update(int uid, @Param("a")BWriteDTO dto);
	public int deleteByUid(final int uid);
	public int deleteByUids(int[] uids);
	
	public int incViewCnt(int uid);	// 조회수 증가
	
	public BWriteDTO searchBySubject(String subject);
}
