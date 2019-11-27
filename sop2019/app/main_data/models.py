from django.db import models

# Create your models here.


class RealPerson(models.Model):
    email = models.CharField(max_length=255, blank=True)
    personal_id = models.CharField(max_length=14, blank=True)
    name = models.CharField(max_length=255, blank=True)
    surname = models.CharField(max_length=255, blank=True)
    address = models.TextField(blank=True)
    Phone = models.CharField(max_length=255, blank=True)
    gender = models.CharField(max_length=10, blank=True)
    percent = models.CharField(max_length=255)
