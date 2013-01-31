package ua.com.itinterview.web.resource;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.com.itinterview.service.CommentService;
import ua.com.itinterview.service.CompanyService;
import ua.com.itinterview.service.PositionService;
import ua.com.itinterview.service.QuestionService;
import ua.com.itinterview.service.TechnologyService;
import ua.com.itinterview.web.command.CommentCommand;
import ua.com.itinterview.web.command.CompanyCommand;
import ua.com.itinterview.web.command.PositionCommand;
import ua.com.itinterview.web.command.QuestionCommand;
import ua.com.itinterview.web.command.QuestionSearchCommand;
import ua.com.itinterview.web.command.TechnologyCommand;
import ua.com.itinterview.web.resource.viewpages.ModeView;

@Controller
@RequestMapping(value = "/question")
public class QuestionResource {

    private final static Logger LOGGER = Logger
	    .getLogger(InterviewResource.class);

    @Autowired
    private CommentService commentService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private TechnologyService technologyService;

    ModeView modeView;

    @RequestMapping(value = "/{questionId}/view", method = RequestMethod.GET)
    public ModelAndView viewQuestion(@PathVariable("questionId") int questionId) {

	QuestionCommand oneQuestionCommand = questionService
		.getQuestionById(questionId);
	List<CommentCommand> commentsForQuestion = commentService
		.getCommentListForQuestion(questionId);

	ModelAndView viewQuestion = new ModelAndView("add_question");

	viewQuestion.addObject("oneQuestionCommand", oneQuestionCommand);
	viewQuestion.addObject("commentsForQuestion", commentsForQuestion);
	modeView = ModeView.VIEW;
	viewQuestion.addObject("mode", modeView);
	return viewQuestion;
    }

    @RequestMapping(value = "/{questionId}/comment_list", method = RequestMethod.GET)
    public ModelAndView getShowCommentList(
	    @PathVariable("questionId") int questionId) {
	List<CommentCommand> commentsToPrint = commentService
		.getCommentListForQuestion(questionId, 0);
	ModelAndView view = new ModelAndView("show_comment_list");
	view.addObject("commentsToPrint", commentsToPrint);
	return view;
    }

    @RequestMapping(value = "/{questionId}/edit", method = RequestMethod.GET)
    public ModelAndView getEditQuestionPage(@PathVariable Integer questionId) {
	ModelAndView view = new ModelAndView("add_question");
	view.addObject(new QuestionCommand());
	modeView = ModeView.EDIT;
	view.addObject("mode", modeView);
	return view;
    }

    @RequestMapping(value = "/{questionId}/edit", method = RequestMethod.POST)
    public ModelAndView editQuestion(@PathVariable Integer questionId,
	    @ModelAttribute QuestionCommand questionCommand) {
	LOGGER.info(questionCommand);
	return new ModelAndView("/index");
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView showQuestionSearchPage() {

	List<CompanyCommand> companies = companyService.getCompanyList();
	List<PositionCommand> positions = positionService.getPositionList();
	List<TechnologyCommand> technologies = technologyService
		.getTechnologyList();
	List<QuestionCommand> questions = questionService
		.getRecentQuestionList();

	ModelAndView view = new ModelAndView("search_questions");
	view.addObject("companies", companies);
	view.addObject("positions", positions);
	view.addObject("technologies", technologies);
	view.addObject("questions", questions);
	view.addObject("questionSearchCommand", new QuestionSearchCommand());

	return view;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView getQuestionSearchResult() {

	return showQuestionSearchPage();
    }

}
