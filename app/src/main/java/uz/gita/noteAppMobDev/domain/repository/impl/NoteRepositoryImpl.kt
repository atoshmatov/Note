package uz.gita.noteAppMobDev.domain.repository.impl

import uz.gita.noteAppMobDev.data.sourse.local.dao.NoteDao
import uz.gita.noteAppMobDev.data.sourse.local.entity.NoteEntity
import uz.gita.noteAppMobDev.domain.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl
@Inject constructor(
    private val noteDao: NoteDao
) : NoteRepository {
    override suspend fun addNote(noteEntity: NoteEntity) {
        noteDao.insert(noteEntity)
    }

    override suspend fun deleteNote(noteEntity: NoteEntity) {
        noteDao.delete(noteEntity)
    }

    override suspend fun updateNote(noteEntity: NoteEntity) {
        noteDao.upDate(noteEntity)
    }

    override suspend fun getNotes(): List<NoteEntity> = noteDao.getNotes()
}