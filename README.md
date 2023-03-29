**Cover Letter Generator**

Cover letter generator for job applications that reduces repetitive customizing of cover letters to a few simple prompts.

The text template for the cover letter is loaded from ```src/main/resources/settings/settings.json```.

The following keywords will be replaced by the application:
- DATE - auto-replaced with today's date
- HIRING_MANAGER - hiring manager (leave blank if unknown, and it'll default to "Hiring manager")
- POSITION - the position at the company you are applying to (f.e. "Rocket Scientist")
- COMPANY - the organization or company you are applying to (f.e.: "NASA")
- FULL_NAME - your full name, this will be saved to and read from the settings

Replace default.txt with any text you wish to use. Implement keywords as described above.

Following is a demonstration of the CLI interface:

<img src="C:\Users\engel\Coding\Cover-Letter-CLI-Tool\src\main\resources\images\ui-example-screenshot.jpeg" width="400"/>

... which generates the output in the specified folder:

```
March 29th, 2023

Dear Jack Barker,

Thank you for taking the time to review my resume. I would like to be considered for the CEO opportunity available within your organization. After learning more about this position, I believe that my abilities can make an immediate and positive impact on your organization. It appears that I have many of the qualifications necessary to be successful in this position.

For the past 6 years I have worked in roles involving troubleshooting complex systems while delivering excellent customer support, querying logs to find trending issues, and developed operational procedures to ensure IT systems are properly supported. I am now looking forward to applying my skills and knowledge within the role of CEO where my experience will make me a valuable asset to your organization.

Specifically, my transferable skills include:

Uncovering needs in the area of software development and technical support in order to offer appropriate solutions.
Delivering technical solutions while offering superior service.
Managing technical projects and activities of all types and size from inception to completion.
Building relationships with internal and external contacts.
Developing and implementing internal processes and strategies that increase overall efficiency and effectiveness.
Participating on teams that exceed goals and objectives.


The chance to meet with you would be a privilege and a pleasure. I look forward to examining all of the ways my background and skill set would benefit Hooli.  You can reach me at (999)99-9999 to arrange an interview.  Thank you for your time and consideration.

Kind regards,

Gavin Belson
```

Original template:
```
DATE

Dear HIRING_MANAGER,

Thank you for taking the time to review my resume. I would like to be considered for the POSITION opportunity available within your organization. After learning more about this position, I believe that my abilities can make an immediate and positive impact on your organization. It appears that I have many of the qualifications necessary to be successful in this position.

For the past 6 years I have worked in roles involving troubleshooting complex systems while delivering excellent customer support, querying logs to find trending issues, and developed operational procedures to ensure IT systems are properly supported. I am now looking forward to applying my skills and knowledge within the role of POSITION where my experience will make me a valuable asset to your organization.

Specifically, my transferable skills include:

Uncovering needs in the area of software development and technical support in order to offer appropriate solutions.
Delivering technical solutions while offering superior service.
Managing technical projects and activities of all types and size from inception to completion.
Building relationships with internal and external contacts.
Developing and implementing internal processes and strategies that increase overall efficiency and effectiveness.
Participating on teams that exceed goals and objectives.


The chance to meet with you would be a privilege and a pleasure. I look forward to examining all of the ways my background and skill set would benefit COMPANY.  You can reach me at (999)99-9999 to arrange an interview.  Thank you for your time and consideration.

Kind regards,

FUlL_NAME

```
