package com.spring.home_work.controller;

import com.spring.home_work.entity.Note;
import com.spring.home_work.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Scanner;

@RestController
@RequiredArgsConstructor
@RequestMapping("/note")
public class NoteController {
    @Autowired
    final NoteService noteService;


    @GetMapping("list")
    public ModelAndView getList() {
        ModelAndView result = new ModelAndView("note");
        result.addObject("notes", noteService.listAll());
        return result;
    }

    @PostMapping("delete")
    public RedirectView deleteById(@RequestParam long id) {
        noteService.deleteById(id);
        return new RedirectView("/note/list");
    }

    @GetMapping("edit")
    public ModelAndView newParamsForNote(@RequestParam long id) {
        ModelAndView result = new ModelAndView("note/edit");
        result.addObject("id", id);
        return result;
    }

    @PostMapping("edit")
    public RedirectView updateList(@RequestParam long id, String title, String content) {

        ModelAndView result = new ModelAndView("note/edit");
        result.addObject("id", id);
        result.addObject("title", title);
        result.addObject("content", content);

        Note note = new Note();
        note.setId(id);
        note.setTitle(title);
        note.setContent(content);
        noteService.update(note);
        return new RedirectView("/note/list");
    }

    @PostMapping("filling")
    public RedirectView filling() {
        Note note1 = new Note();
        note1.setTitle("1T");
        note1.setContent("1C");
        noteService.add(note1);
        Note note2 = new Note();
        note2.setTitle("2T");
        note2.setContent("2C");
        noteService.add(note2);
        return new RedirectView("/note/list");
    }


}
