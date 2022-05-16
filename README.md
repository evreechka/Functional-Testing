# Functional-Testing

Functional testing of web-site interface https://archive.org/

**Web-site:**
Archive.org. 
Nonprofit organisation established to preserve Web sites by taking regular "snapshots". The Wayback Machine provides links to older versions of a webpage. There are special collections, for example on Web pioneers. - https://archive.org/

**Performance Requirements:**

1. Test coverage should be generated based on a set of site usage precedents.
2. Testing must be performed automatically - using the Selenium automated testing system.
3. Test templates should be generated using Selenium IDE and executed using Selenium RC in Firefox and Chrome browsers.
4. It is assumed that the site under test uses dynamic generation of elements on the page, i.e. element selection in the DOM should be performed not based on its ID, but using XPath.
