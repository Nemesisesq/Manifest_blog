require 'page-object'

class ListOfBlogs
  include PageObject

  page_url "http://localhost:8080/Manifest-Blog/"

  link(:anchorTag, :name => 'blog')
end
