require 'watir-webdriver'
require 'page-object'
include PageObject::PageFactory

Given (/^I visit the blog for my favorite blogger$/) do
  openFirstPage()
end

When (/^I choose a blog post$/) do
  openBlog()
end

Then (/^I should see the blog post$/) do
  readTitle()
end
