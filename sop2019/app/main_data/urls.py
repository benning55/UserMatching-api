from django.urls import path
from main_data.views import person_view

urlpatterns = [
    path('person-request/', person_view, name="person_view"),
]
