package com.revaluper.rep_crud_project.report.dao;

import com.revaluper.rep_crud_project.report.model.dto.ReportDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReportMapper {
    //신고게시판 모두조회
    List<ReportDTO> findAllReport();

    //신고게시판 단일조회
    ReportDTO findReport(@Param("repId") String repId);

    //신고게시판 수정
    int updateReport();

    //신고게시판 삭제
    int deleteReport(@Param("repId") String repId);

    //신고 인서트
    void insertReport(ReportDTO newReport);
}



