package com.revaluper.rep_crud_project.report.controller.controller;

import com.revaluper.rep_crud_project.report.model.dto.ReportDTO;
import com.revaluper.rep_crud_project.report.service.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    //요청이 들어왔을 때 실행되는 순서
    //controller -> service -> mapper(dao) -> xml
    //조회 - @GetMapping
    //저장 - @PostMapping
    //수정 - @PutMapping
    //삭제 - @DeleteMapping
    @ResponseBody
    @GetMapping
    public List<ReportDTO> findReportList() {
        System.out.println("신고게시판 전체조회 시작");
        List<ReportDTO> reportList = reportService.findAll();
        System.out.println("신고게시판 전체조회 끝");
        return reportList;
    }

    //단일 조회컨트롤러
    @ResponseBody
    @GetMapping("/{repId}")
    public ReportDTO findReport(@PathVariable String repId) {
        System.out.println("신고게시판 단일조회 시작 - 조회아이디 : " + repId);
        ReportDTO report = reportService.find(repId);
        System.out.println("신고게시판 단일조회 끝 - 조회아이디 : " + repId);
        return report;
    }

    //삭제
    @ResponseBody
    @DeleteMapping("/{repId}")
    public void deleteReport(@PathVariable String repId) {
        System.out.println("신고게시판 아이디 삭제 시작 - Id : " + repId);
        reportService.delete(repId);
        System.out.println("신고게시판 아이디 삭제 끝 - Id : " + repId);
    }

    //저장(insert)기능 추가
    @ResponseBody
    @PostMapping("/insert") //PostMapping은 데이터를 body로 보내야함.
    public void insertReport(@RequestBody ReportDTO report) {
        System.out.println("신고게시판 데이터 삽입 시작 - 저장할 데이터 :"+ report.toString());
        reportService.save(report);
        System.out.println("신고게시판 데이터 삽입 끝");
    }

    /**
     * DB에 PK, UK 는 유일값 -> 고로 테이블에 PK는 하나고 2개이상 같은값이 저장 불가.
     * 그래서 DB에 저장(insert)할때는 저장하기 전에 해당 저장 값이 있는지 조회 하고 있으면 이미 데이터가 있다고 에러를 내야해.
     *
     * 수정도 마찬가지로 데이터가 있어야 수정하는거니까 수정 전에 먼저 조회하고 수정. 없다면 에러 ex) 데이터가 존재하지 않습니다.
     */
}
