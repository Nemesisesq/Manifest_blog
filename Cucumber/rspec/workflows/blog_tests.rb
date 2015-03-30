module BlogWatirTest
 def openFirstPage()
   visit_page ListOfBlogs
 end

  def openBlog()
    on_page(ListOfBlogs).anchorTag
    sleep(1)
  end

  def readTitle()
    on_page(Blog) do
      title = @browser.div(:class => 'title').h1.text
      if title.length > 0
        return true
      end
      return false
    end
  end
end
World BlogWatirTest