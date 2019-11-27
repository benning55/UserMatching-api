from django.urls import path
from main_data.views import person_view, result_data, get_person
from main_data.tests import chesse

urlpatterns = [
    path('person-request/', person_view, name="person_view"),
    path('result-data/', result_data, name="result_data"),
    path('get-person/', get_person, name="get_person")
]
