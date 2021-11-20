package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping
    public String displayAllEvents(Model model){
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

//    @GetMapping
//    public String displayAllEvents(Model model){
//        HashMap<String,String> events = new HashMap<>();
//        events.put("Menteaship","A fun meetup for connecting with mentors");
//        events.put("Code With Pride","A fun meetup sponsored by LaunchCode");
//        events.put("Javascripty", "An imaginary meetup for Javascript developers");
//        model.addAttribute("events",events);
//        return "events/index";
//    }

    // lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm(){
        return "events/create";
    }

    @PostMapping("create")
    public String createEvent(@ModelAttribute Event newEvent){
        EventData.add(newEvent);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model){
        model.addAttribute("title","Delete Events");
        model.addAttribute("events",EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventForm(@RequestParam(required = false) int[] eventIds){
        if(eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
        return "redirect:";
    }

    @GetMapping("edit/{eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId) {
        Event event = EventData.getById(eventId);
        model.addAttribute("event",event);
        model.addAttribute("title","Edit Event " + event.getName() + " (" + event.getId() + ")");
        return "events/edit";
    }

    @PostMapping("edit")
    public String processEditForm(@RequestParam int eventId,@RequestParam String name,@RequestParam String description) {
        EventData.getById(eventId).setName(name);
        EventData.getById(eventId).setDescription(description);
        return "redirect:";
    }

}
