package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.org.ui.BasePage;


public class JobPage extends BasePage {
    WebDriver driver;

    public JobPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        // TODO Auto-generated constructor stub
    }

    private static final Logger logger = LoggerFactory.getLogger(JobPage.class);


    @FindBy(id = "job-keywords")
    public WebElement JobSearchInput;

    @FindBy(id = "SearchTabs1_JobsSearchFormControl_JobType")
    public WebElement JobTypeDropdown;

    @FindBy(id = "SearchTabs1_JobsSearchFormControl_jobsTopTierLocation")
    public WebElement JobRegionDropdown;

    @FindBy(id = "SearchTabs1_JobsSearchFormControl_jobsDistrictsLocation")
    public WebElement JobDistrictsDropdown;

    @FindBy(id = "SearchTabs1_JobsSearchFormControl_jobsTopTierCategory")
    public WebElement JobCategoryDropdown;

    @FindBy(id = "SearchTabs1_JobsSearchFormControl_jobsSecondTierCategory")
    public WebElement JobSubcategoryDropdown;

    @FindBy(id = "SearchTabs1_JobsSearchFormControl_jobsAnnualSalaryMin")
    public WebElement JobAnnualSalaryMin;

    @FindBy(id = "SearchTabs1_JobsSearchFormControl_jobsAnnualSalaryMax")
    public WebElement JobAnnualSalaryMax;

    @FindBy(id = "AnnualPayType")
    public WebElement JobAnnualPayButton;

    @FindBy(id = "HourlyPayType")
    public WebElement JobHourlyPayButton;

   @FindBy(class = "btn-j-search")
    public WebElement SearchJobButton;

    @FindBy(class = "advanced-job-search j-layout-left")
    public WebElement AdvancedSearchJob;

}