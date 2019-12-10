package com.hotel.controller;


import com.hotel.pojo.Team;
import com.hotel.service.TeamService;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Resource
    private TeamService teamService;

    @GetMapping("/all")
    public List<Team> getAllTeam(){
        return teamService.getAllTeam();
    }
    @PostMapping("/login")
    public Team login(@RequestBody Team t){
        return teamService.login(t);
    }
    @PostMapping("/save")
    public String saveTeam(@RequestBody Team t){
        boolean flag=teamService.saveTeam(t);
        String result=(flag ? "success":"fail");
        return result;
    }
    @GetMapping("/all/{tid}")
    public Team getTeamByTid(@PathVariable int tid){
        return teamService.getTeamByTid(tid);
    }
    @GetMapping("/delete/{tid}")
    public String deleteTeamByTid(@PathVariable int tid){
        boolean flag=teamService.deleteTeamByTid(tid);
        String result=(flag ? "success":"fail");
        return result;
    }
    @PostMapping("/update")
    public String updateTeamByTid(@RequestBody Team t){
        boolean flag=teamService.updateTeamByTid(t);
        String result=(flag ? "success":"fail");
        return result;
    }
}
