# Generated by Django 2.1.14 on 2019-11-27 09:36

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('main_data', '0002_auto_20191127_0759'),
    ]

    operations = [
        migrations.AddField(
            model_name='realperson',
            name='address',
            field=models.TextField(blank=True),
        ),
    ]
