//package ru.javawebinar.topjava.web.meal;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import ru.javawebinar.topjava.model.Meal;
//import ru.javawebinar.topjava.model.User;
//
//import javax.servlet.http.HttpServletRequest;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.time.temporal.ChronoUnit;
//
//import static ru.javawebinar.topjava.util.DateTimeUtil.parseLocalDate;
//import static ru.javawebinar.topjava.util.DateTimeUtil.parseLocalTime;
//
//@RestController
//@RequestMapping(value = MealRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
//public class MealRestController extends AbstractMealController {
//
//    static final String REST_URL = "/rest/meals";
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable int id) {
//        super.delete(id);
//    }
//
//    @GetMapping("/update/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void update(@RequestBody int id) {
//        super.get(id);
//    }
//
//    @GetMapping("/create")
//    public String create(Model model) {
//        model.addAttribute("meal", new Meal(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES), "", 1000));
//        return "mealForm";
//    }
//
//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public String updateOrCreate(@RequestBody Meal meal) {
//        if (meal == null) {
//            super.create(meal);
//        } else {
//            super.update(meal, 1);
//        }
//        return "redirect:/meals";
//    }
//
//    @GetMapping("/filter")
//    public String getBetween(HttpServletRequest request, Model model) {
//        LocalDate startDate = parseLocalDate(request.getParameter("startDate"));
//        LocalDate endDate = parseLocalDate(request.getParameter("endDate"));
//        LocalTime startTime = parseLocalTime(request.getParameter("startTime"));
//        LocalTime endTime = parseLocalTime(request.getParameter("endTime"));
//        model.addAttribute("meals", super.getBetween(startDate, startTime, endDate, endTime));
//        return "meals";
//    }
//}