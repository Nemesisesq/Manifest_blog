require 'watir-webdriver'

Before do |scenario|
  @browser = Watir::Browser.new :firefox
end

After do |scenario|
  @browser.close
end